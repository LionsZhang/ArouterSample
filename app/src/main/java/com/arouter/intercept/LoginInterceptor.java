package com.arouter.intercept;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.arouter.service.UserInfoService;


/**
 * <br> ClassName:   LoginInterceptor
 * <br> Description: 面向切面的编程思想，注解会自动注册到Arouter路由中心
 * <br>
 * <br> Author:      lionszhang
 * <br> Date:        2017/8/19 10:32
 */
//@Interceptor(priority = 100)
@Interceptor(name = "login", priority = 100)
public class LoginInterceptor implements IInterceptor {
    private static final String LOGIN_REGISTE_LOGIN_TYPE = "LOGIN_REGISTE_TYPE";
    private static final int LOGIN_REGISTE_LOGIN_USER = 1002;
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        int extra = postcard.getExtra();
        if (extra != ExtrasConstant.EXTRAS_NEED_LOGIN) {
            //没有标记
            callback.onContinue(postcard);
            return;
        }
        UserInfoService service = ARouter.getInstance().navigation(UserInfoService.class);
        if (service.isLogin()){
            //已经登陆了
            callback.onContinue(postcard);
            return;
        }
        //未登陆，进入登陆页面
        if (mLoginFutureTask != null) {
            mLoginFutureTask.onContinue(false);
        }
        mLoginFutureTask = new LoginFutureTask(postcard, callback);
        ARouter.getInstance().build("/loginreg/loginregiste")//登录注册页面
                .withInt(LOGIN_REGISTE_LOGIN_TYPE, LOGIN_REGISTE_LOGIN_USER)
                .navigation();
    }

    private static LoginFutureTask mLoginFutureTask;

    private static class LoginFutureTask {

        Postcard postcard;
        InterceptorCallback callback;

        LoginFutureTask(Postcard postcard, InterceptorCallback callback) {
            this.postcard = postcard;
            this.callback = callback;
        }

        void onContinue(boolean isSuccessLogin){
            if (isSuccessLogin) {
                callback.onContinue(postcard);
            }else{
                callback.onInterrupt(null);
            }
            mLoginFutureTask = null;
        }
    }

    /**
     *<br> Description: 对拦截的任务进行处理
     *<br> Author:      Longzf
     *<br> Date:        2017/8/19 10:54
     */
    public static void onContinue(boolean isLogin){
        if (mLoginFutureTask != null) {
            mLoginFutureTask.onContinue(isLogin);
        }
    }

    /**
     *<br> Description: 是否有任务未处理
     *<br> Author:      Longzf
     *<br> Date:        2017/8/19 10:54
     */
    public static boolean hasFutureTask(){
        return mLoginFutureTask != null;
    }

    @Override
    public void init(Context context) {}
}
