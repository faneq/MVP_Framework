package xf.mvp.com.mvp_framework.network.api.service;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import xf.mvp.com.mvp_framework.main.mvp.model.entity.WeatherEntity;

/**
 * Created by guangjiego on 2017/3/21.
 */

public interface ApiSever {
    @GET("open/api/weather/json.shtml")
    Flowable<WeatherEntity> getTitles(@Query("city") String city);
}
