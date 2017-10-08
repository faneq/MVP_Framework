package xf.mvp.com.mvp_framework.utils;

/**
 * Context:权限申请回调
 * Created by fanenqian on 2017/4/25 16:44
 */
public interface IView {

    /**
     * 权限申请回调
     */
    void success(String message);

    void error(String message);
}
