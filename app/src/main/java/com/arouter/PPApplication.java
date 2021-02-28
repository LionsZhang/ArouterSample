package com.arouter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author: lionszhang
 * @Filename:
 * @Description:
 * @Copyright: Copyright (c) 2016 Tuandai Inc. All rights reserved.
 * @date: 2017/8/1 21:45
 */
public class PPApplication extends Application {

    private static PPApplication INSTANCE;

    private static final String USER_INFO_DB = "user_info_db.realm";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;
        // initCarshReport();

        ARouter.init(this);

    }




    /**
     * <br> Description: Debug模式抓获异常保存本地，release线上模式采用腾讯bugly捕获异常
     * <br> Author:     zhangqiang
     * <br> Date:        2017/9/20 16:13
     */

//    private void initCarshReport() {
//        if (AppConfig.IS_DEBUG_ABLE) {
//            // 异常捕获 本地
//            CrashHandler crashHandler = CrashHandler.getInstance();
//            // 注册crashHandler
//            crashHandler.init(getApplicationContext());
//        } else {
//            //腾讯bugly集成
////            CrashReport.initCrashReport(getApplicationContext());
////            CrashReport.setIsDevelopmentDevice(getApplicationContext(), AppConfig.IS_DEBUG_ABLE);
//        }
//    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        INSTANCE = this;
    }

    @SuppressLint("NewApi")
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        INSTANCE = this;
    }

    public static Context getContext() {
        return INSTANCE;
    }

}
