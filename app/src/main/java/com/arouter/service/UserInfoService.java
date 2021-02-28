package com.arouter.service;


import android.text.TextUtils;

import androidx.annotation.UiThread;

import com.alibaba.android.arouter.facade.annotation.Route;


/**
 * @author: lionszhang
 * @Filename: UserInfoService
 * @Description: 登录注册用户信息管理服务
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/6/9 10:25
 */
@Route(path = ARouterConstant.LOADING_AND_REGISTER_SERVICE, name = "登录注册用户信息管理服务")
public class UserInfoService extends UserBaseService  {

    /**
     * 保存存管状态
     *
     * @param mAccountStage 存管状态
     */
    @UiThread
    public void saveAccountStage(int mAccountStage) {
        getUserInfoManage().getUserInfoField().saveAccountStage(mAccountStage);
    }

    /**
     * 保存存管手机号码
     *
     * @param mMobile 存管手机号码
     */
    @UiThread
    public void saveMobile(String mMobile) {
        if (!TextUtils.isEmpty(mMobile)) {
            /***bugly设置电话号码***/
//            CrashReport.setUserId(mMobile);
        }
        getUserInfoManage().getUserInfoField().saveMobile(mMobile);
    }

    /**
     * <br> Description: 获取手机号码
     * <br> Author:      wuheng
     * <br> Date:        2017/8/10 12:08
     */
    public String getMobile() {
        return getUserInfoManage().getUserInfoField().getMobile();
    }

    /**
     * <br> Description: 保存token
     * <br> Author:      wuheng
     * <br> Date:        2017/8/10 12:09
     */
    public void saveToken(String token) {
        getUserInfoManage().getUserInfoField().saveToken(token);
    }

    /**
     * <br> Description: 获取token
     * <br> Author:      wuheng
     * <br> Date:        2017/8/10 12:11
     */
    public String getToken() {
        return getUserInfoManage().getUserInfoField().getToken();
    }

    /**
     *<br> Description: 保存用户名
     *<br> Author:      suzhou
     *<br> Date:        2017/8/21 19:49
     */
    public void saveUsername(String username) {
        getUserInfoManage().getUserInfoField().saveUsername(username);
    }

    /**
     *<br> Description: 保存用户名
     *<br> Author:      suzhou
     *<br> Date:        2017/8/21 19:49
     */
    public void saveRealUsername(String username) {
        getUserInfoManage().getUserInfoField().saveRealUsername(username);
    }

    /**
     *<br> Description: 获取用户名
     *<br> Author:      suzhou
     *<br> Date:        2017/8/21 19:51
     */
    public String getUsername() {
        return getUserInfoManage().getUserInfoField().getUsername();
    }
    /**
     *<br> Description: 获取用户名
     *<br> Author:      suzhou
     *<br> Date:        2017/8/21 19:51
     */
    public String getRealUsername() {
        return getUserInfoManage().getUserInfoField().getRealUsername();
    }

    /**
     *<br> Description: 是否登陆
     *<br> Author:      Longzf
     *<br> Date:        2017/8/19 10:36
     */
    public boolean isLogin(){
        return ! TextUtils.isEmpty(getToken());
    }



    /**
     *<br> Description: 保存实名认证状态
     *<br> Author:     zhangqiang
     *<br> Date:        2017/8/21 19:43
     */

    public void saveRealNameAuth(final boolean isRealNameAuth) {
        getUserInfoManage().getUserInfoField().saveRealNameAuth(isRealNameAuth);
    }
    /**
     *<br> Description: 获取实名认证状态
     *<br> Author:     zhangqiang
     *<br> Date:        2017/8/21 19:43
     */

    public boolean getRealNameAuth() {
        return getUserInfoManage().getUserInfoField().getRealNameAuth();
    }
    /**
     *<br> Description: 保存风险评测功能
     *<br> Author:     zhangqiang
     *<br> Date:        2017/8/21 19:43
     */

    public void saveRiskEval(final boolean isRiskEval) {
        getUserInfoManage().getUserInfoField().saveRiskEval(isRiskEval);
    }
    /**
     *<br> Description:  获取风险评估状态
     *<br> Author:     zhangqiang
     *<br> Date:        2017/8/21 19:43
     */

    public boolean getRiskEval() {
        return getUserInfoManage().getUserInfoField().getRiskEval();
    }

}
