package xf.mvp.com.mvp_framework.main.di.modul;


import android.app.Activity;
import android.support.v4.app.Fragment;


import dagger.Module;
import dagger.Provides;
import xf.mvp.com.mvp_framework.main.di.component.PerFragment;

@Module
public class FragmentModule {


    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
