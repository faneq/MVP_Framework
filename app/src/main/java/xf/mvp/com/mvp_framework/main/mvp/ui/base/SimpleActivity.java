package xf.mvp.com.mvp_framework.main.mvp.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import xf.mvp.com.mvp_framework.App;
import xf.mvp.com.mvp_framework.main.mvp.ui.weight.MySwipeBackActivity;

/**
 * Context: 无MVP的activity基类
 * Created by fanenqian on 2017/3/20 16:04
 */

public abstract class SimpleActivity extends MySwipeBackActivity {

    protected Activity mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        setSwipeBackEnable(true);
        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        App.getInstance().addActivity(this);
        initEventAndData();
    }

//    protected void setToolBar(Toolbar toolbar, String title) {
//        toolbar.setTitle(title);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressedSupport();
//            }
//        });
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        mUnBinder.unbind();
    }

    protected abstract int getLayout();

    protected abstract void initEventAndData();
}
