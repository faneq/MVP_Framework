package xf.mvp.com.mvp_framework.main.mvp.model.contract;

import xf.mvp.com.mvp_framework.main.mvp.presenter.BasePresenter;
import xf.mvp.com.mvp_framework.main.mvp.presenter.BaseView;

/**
 * Created by feq on 2017/10/7.
 */

public class MainContract {
    public interface View extends BaseView {
        void showContent(Object list);

        void error(Throwable throwable);
    }

    public interface PerSenter extends BasePresenter<View> {
        void getData();
    }
}
