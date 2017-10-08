package xf.mvp.com.mvp_framework.main.mvp.presenter;


public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}