package xf.mvp.com.mvp_framework.main.di.modul;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xf.mvp.com.mvp_framework.App;
import xf.mvp.com.mvp_framework.network.RetrofitHelper;
import xf.mvp.com.mvp_framework.network.api.service.ApiSever;

/**
 * Context:
 * Created by fanenqian on 2017/4/24 14:12
 */
@Module
public class AppModule {
    public final App mApp;

    public AppModule(App mApp) {
        this.mApp = mApp;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mApp;
    }

    @Provides
    ApiSever providesApiService(RetrofitHelper retrofitHelper) {
        return retrofitHelper.getApiSever();
    }
}
