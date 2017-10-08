package xf.mvp.com.mvp_framework.main.mvp.presenter;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by guangjiego on 2017/3/22.
 * 基于Rx的Presenter封装,控制订阅的生命周期
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;
    protected CompositeDisposable mcompositeDisposable;
    protected Disposable subscription;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
        clear();
    }

    protected void addSubscrebe(Disposable subscription) {
        this.subscription = subscription;
        if (mcompositeDisposable == null) {
            mcompositeDisposable = new CompositeDisposable();
        }
        mcompositeDisposable.add(subscription);
    }

    protected void unSubscribe() {
        if (mcompositeDisposable != null) {
            mcompositeDisposable.remove(subscription);
        }
    }

    protected void clear() {
        if (null != mcompositeDisposable)
            if (!mcompositeDisposable.isDisposed()) {
                mcompositeDisposable.clear();
            }
    }
}
