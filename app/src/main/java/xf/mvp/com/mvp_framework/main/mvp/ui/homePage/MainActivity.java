package xf.mvp.com.mvp_framework.main.mvp.ui.homePage;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.orhanobut.logger.Logger;
import com.sunfusheng.glideimageview.GlideImageLoader;
import com.sunfusheng.glideimageview.GlideImageView;

import butterknife.BindView;
import xf.mvp.com.mvp_framework.R;
import xf.mvp.com.mvp_framework.main.di.component.ActivityComponent;
import xf.mvp.com.mvp_framework.main.mvp.model.contract.MainContract;
import xf.mvp.com.mvp_framework.main.mvp.model.entity.WeatherEntity;
import xf.mvp.com.mvp_framework.main.mvp.presenter.MainPresenter;
import xf.mvp.com.mvp_framework.main.mvp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.ivTest)
    ImageView ivTest;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }


    @Override
    protected void initEventAndData() {
        tvContent.setText("1111");
        mPresenter.getData();
        RequestOptions requestOptions = new RequestOptions();
        //        requestOptions.
        GlideImageView imageView = new GlideImageView(this);
        //        imageView.getImageLoader().
        GlideImageLoader.create(ivTest).
                loadImage("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3497049841,2955309607&fm=27&gp=0.jpg",
                        R.drawable.shadow_bottom);
    }


    @Override
    public void showContent(Object list) {
        if (null != list) {
            WeatherEntity entity = (WeatherEntity) list;
            tvContent.setText(entity.getCity() + ":\n温度:" +
                    entity.getData().getWendu() + "°\n感冒：" + entity.getData().getGanmao());
        }
    }

    @Override
    public void error(Throwable throwable) {
        Logger.i(throwable.getMessage());
    }

    @Override
    public void onDataSynEvent(String event) {
        super.onDataSynEvent(event);

    }
}
