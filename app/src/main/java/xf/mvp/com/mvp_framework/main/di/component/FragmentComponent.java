package xf.mvp.com.mvp_framework.main.di.component;

import android.app.Activity;

import dagger.Component;
import xf.mvp.com.mvp_framework.main.di.modul.FragmentModule;

/**
 * Created by guangjiego on 2017/3/21.
 */
@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
}
