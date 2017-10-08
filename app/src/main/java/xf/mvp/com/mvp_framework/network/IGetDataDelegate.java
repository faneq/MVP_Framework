package xf.mvp.com.mvp_framework.network;

/**
 * 作者 :fanenqian
 * 时间：2017-10-7 11:29:19
 */
public interface IGetDataDelegate<T> {
    void getDataSuccess(T t);

    void getDataError(Throwable throwable);
}
