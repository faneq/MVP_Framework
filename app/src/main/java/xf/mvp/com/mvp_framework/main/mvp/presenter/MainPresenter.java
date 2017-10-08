package xf.mvp.com.mvp_framework.main.mvp.presenter;


import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import xf.mvp.com.mvp_framework.main.mvp.model.contract.MainContract;
import xf.mvp.com.mvp_framework.main.mvp.model.entity.WeatherEntity;
import xf.mvp.com.mvp_framework.main.mvp.model.interactor.MainInteractor;
import xf.mvp.com.mvp_framework.network.IGetDataDelegate;

/**
 * Created by feq on 2017/10/7.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.PerSenter {
    @Inject
    MainInteractor interactor;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void getData() {
        Disposable disposable =
                interactor.getWeatherInfo(new IGetDataDelegate<WeatherEntity>() {


                    @Override
                    public void getDataSuccess(WeatherEntity responseBody) {
                        mView.showContent(responseBody);
                    }

                    @Override
                    public void getDataError(Throwable throwable) {
                        mView.error(throwable);
                    }
                });
        addSubscrebe(disposable);
    }
}
