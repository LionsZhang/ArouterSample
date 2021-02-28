package com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.arouter.R
import com.arouter.intercept.LoginNavigationCallbackImpl

import com.arouter.service.ARouterConstant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        //启动Activity
ARouter.getInstance().build(ARouterConstant.MAIN2ACTIVITY)
                     .withString("msg", "ARouter传递过来的需要登录的参数msg")
                     .navigation(this, LoginNavigationCallbackImpl());//第二个参数是路由跳转的回调
    }
}