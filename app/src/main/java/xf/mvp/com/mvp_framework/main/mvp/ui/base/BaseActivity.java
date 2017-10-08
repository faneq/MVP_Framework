package xf.mvp.com.mvp_framework.main.mvp.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import xf.mvp.com.mvp_framework.App;
import xf.mvp.com.mvp_framework.main.di.component.ActivityComponent;
import xf.mvp.com.mvp_framework.main.di.component.DaggerActivityComponent;
import xf.mvp.com.mvp_framework.main.mvp.presenter.BasePresenter;
import xf.mvp.com.mvp_framework.main.mvp.presenter.BaseView;

/**
 * Context:activity基类
 * Created by fanenqian on 2017/4/24 18:00
 */

public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity implements BaseView {
    @Inject
    protected T mPresenter;
    protected Context mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject(getActivityComponent());
        mContext = this;
        setContentView(getLayoutId());
        if (useEventBus())//如果要使用eventbus请将此方法返回true
            EventBus.getDefault().register(this);//注册到事件主线
        mPresenter.attachView(this);
        mUnBinder = ButterKnife.bind(this);
        App.getInstance().addActivity(this);
        initEventAndData();
    }

    protected abstract int getLayoutId();

    protected abstract void initInject(ActivityComponent activityComponent);

    protected abstract void initEventAndData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
        if (mUnBinder != Unbinder.EMPTY) mUnBinder.unbind();
        if (useEventBus())//如果要使用eventbus请将此方法返回true
            EventBus.getDefault().unregister(this);
        this.mPresenter = null;
        this.mUnBinder = null;
        this.mContext = null;
        App.getInstance().removeActivity(this);
    }

    /**
     * 是否使用eventBus,默认为使用(true)，
     *
     * @return
     */
    protected boolean useEventBus() {
        return true;
    }

    /**
     * activity 注入对象
     *
     * @return
     */
    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .build();
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //EventBus接收方法，在ui线程执行
    public void onDataSynEvent(String event) {
    }

}
