package xf.mvp.com.mvp_framework;

import android.app.Activity;
import android.app.Application;

import java.util.HashSet;
import java.util.Set;

import xf.mvp.com.mvp_framework.main.di.component.AppComponent;
import xf.mvp.com.mvp_framework.main.di.component.DaggerAppComponent;
import xf.mvp.com.mvp_framework.main.di.modul.AppModule;
import xf.mvp.com.mvp_framework.main.di.modul.RetrofitModule;

/**
 * Created by feq on 2017/10/7.
 */

public class App extends Application {
    private static App app;
    private AppComponent mAppComponent;
    private Set<Activity> allActivities;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initAppComponent();
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).
                retrofitModule(new RetrofitModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static App getInstance() {
        return app;
    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
//        getThreadPool().shutdown();
    }

}
