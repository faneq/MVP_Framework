package xf.mvp.com.mvp_framework.main.di.component;

/**
 * Created by guangjiego on 2017/4/25.
 */


import dagger.Component;
import xf.mvp.com.mvp_framework.main.mvp.ui.homePage.MainActivity;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}

