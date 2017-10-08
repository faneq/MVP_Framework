package xf.mvp.com.mvp_framework.main.di.component;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Component;
import xf.mvp.com.mvp_framework.main.di.modul.AppModule;
import xf.mvp.com.mvp_framework.main.di.modul.RetrofitModule;
import xf.mvp.com.mvp_framework.network.api.service.ApiSever;

/**
 * Created by fanenqian on 2017/4/24 14:16
 */
@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface AppComponent {
    Context getContext();

    ApiSever getApiServices();
}
