package xf.mvp.com.mvp_framework.main.mvp.model.interactor;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import xf.mvp.com.mvp_framework.main.mvp.model.entity.WeatherEntity;
import xf.mvp.com.mvp_framework.network.IGetDataDelegate;
import xf.mvp.com.mvp_framework.network.api.service.ApiSever;
import xf.mvp.com.mvp_framework.utils.RxUtil;

/**
 * Created by feq on 2017/10/8.
 */

public class MainInteractor {
    private ApiSever apiSever;

    @Inject
    public MainInteractor(ApiSever apiSever) {
        this.apiSever = apiSever;
    }

    public Disposable getWeatherInfo(IGetDataDelegate<WeatherEntity> iGetDataDelegate) {
        return apiSever.getTitles("北京").compose(RxUtil.background()).subscribe(new Consumer<WeatherEntity>() {
            @Override
            public void accept(@NonNull WeatherEntity weatherEntity) throws Exception {
                iGetDataDelegate.getDataSuccess(weatherEntity);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                iGetDataDelegate.getDataError(throwable);
            }
        });
    }
}
