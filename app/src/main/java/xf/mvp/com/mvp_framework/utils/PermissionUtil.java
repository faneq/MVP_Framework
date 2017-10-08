package xf.mvp.com.mvp_framework.utils;

import android.Manifest;

import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;


/**
 * Context:权限管理
 * Created by fanenqian on 2017/4/25 16:40
 */

public class PermissionUtil {
    public static final String TAG = "Permission";


    public interface RequestPermission {
        void onRequestPermissionSuccess();
    }


    /**
     * 请求摄像头权限
     */
    public static void launchCamera(final RequestPermission requestPermission, RxPermissions rxPermissions, final IView view) {
        //先确保是否已经申请过摄像头，和写入外部存储的权限
        boolean isPermissionsGranted =
                rxPermissions
                        .isGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE) &&
                        rxPermissions
                                .isGranted(Manifest.permission.CAMERA);

        if (isPermissionsGranted) {//已经申请过，直接执行操作
            requestPermission.onRequestPermissionSuccess();
            view.success("摄像头权限申请成功");
        } else {//没有申请过，则申请
            rxPermissions
                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE
                            , Manifest.permission.CAMERA)
                    .subscribe(aBoolean -> {
                        if (aBoolean) {
                            Logger.i(TAG, "request WRITE_EXTERNAL_STORAGE and CAMERA success");
                            view.success("摄像头权限申请成功");
                            requestPermission.onRequestPermissionSuccess();
                        } else {
                            view.error("摄像头权限申请失败");
                        }
                    });
        }
    }


    /**
     * 请求外部存储的权限
     */
    public static void externalStorage(final RequestPermission requestPermission, RxPermissions rxPermissions, final IView view) {
        //先确保是否已经申请过摄像头，和写入外部存储的权限
        boolean isPermissionsGranted =
                rxPermissions
                        .isGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (isPermissionsGranted) {//已经申请过，直接执行操作
            requestPermission.onRequestPermissionSuccess();
            view.success("request WRITE_EXTERNAL_STORAGE and CAMERA success");
        } else {//没有申请过，则申请
            rxPermissions
                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .subscribe(aBoolean -> {
                        if (aBoolean) {
                            Logger.i(TAG, "request WRITE_EXTERNAL_STORAGE and CAMERA success");
                            view.success("request WRITE_EXTERNAL_STORAGE and CAMERA success");
                        } else {
                            view.error("request permissons failure");
                        }
                    });
        }
    }

    /**
     * 请求发送短信权限
     */
    public static void sendSms(final RequestPermission requestPermission, RxPermissions rxPermissions, final IView view) {
//先确保是否已经申请过权限
        boolean isPermissionsGranted =
                rxPermissions
                        .isGranted(Manifest.permission.SEND_SMS);
        if (isPermissionsGranted) {//已经申请过，直接执行操作
            requestPermission.onRequestPermissionSuccess();
        } else {//没有申请过，则申请
            rxPermissions
                    .request(Manifest.permission.SEND_SMS)
                    .subscribe(aBoolean -> {
                        if (aBoolean) {
                            Logger.i(TAG, "request SEND_SMS success");
                            requestPermission.onRequestPermissionSuccess();
                            view.success("request SEND_SMS success");
                        } else {
                            view.error("request permissons failure");
                        }
                    });
        }
    }

//

    /**
     * 请求打电话权限
     */
    public static void callPhone(final RequestPermission requestPermission, RxPermissions rxPermissions, final IView view) {
//先确保是否已经申请过权限
        boolean isPermissionsGranted =
                rxPermissions
                        .isGranted(Manifest.permission.CALL_PHONE);

        if (isPermissionsGranted) {//已经申请过，直接执行操作
            requestPermission.onRequestPermissionSuccess();
        } else {//没有申请过，则申请
            rxPermissions
                    .request(Manifest.permission.CALL_PHONE)
                    .subscribe(aBoolean -> {
                        if (aBoolean) {
                            view.success("request callPhone success");
                            requestPermission.onRequestPermissionSuccess();
                        } else {
                            view.error("request permissons failure");
                        }
                    });
        }
    }
//
//

    /**
     * 请求获取手机状态的权限
     */
    public static void readPhonestate(final RequestPermission requestPermission, RxPermissions rxPermissions, final IView view) {
//先确保是否已经申请过权限
        boolean isPermissionsGranted =
                rxPermissions
                        .isGranted(Manifest.permission.READ_PHONE_STATE);

        if (isPermissionsGranted) {//已经申请过，直接执行操作
            requestPermission.onRequestPermissionSuccess();
        } else {//没有申请过，则申请
            rxPermissions
                    .request(Manifest.permission.READ_PHONE_STATE)
                    .subscribe(aBoolean -> {
                        if (aBoolean) {
                            Logger.i(TAG, "request readPhonestate success");
                            requestPermission.onRequestPermissionSuccess();
                            view.success("request readPhonestate success");
                        } else {
                            Logger.e(TAG, "request permissons failure");
                            view.error("request permissons failure");
                        }
                    });
        }
    }
}

