package com.arouter.service;

/**
 * @author: lionszhang
 * @Filename:
 * @Description:
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/6/8 15:45
 */

public interface IUserInfoField {

    /**
     * 保存存管状态
     *
     * @param mAccountStage 存管状态
     */
    void saveAccountStage(int mAccountStage);

    /**
     * 保存存管手机号码
     *
     * @param mMobile 存管手机号码
     */
    void saveMobile(String mMobile);

    /**
     * <br> Description: 获取手机号码
     * <br> Author:      lionszhang
     * <br> Date:        2017/8/10 12:06
     */
    String getMobile();

    /**
     * <br> Description: 保存token
     * <br> Author:     lionszhang
     * <br> Date:        2017/8/10 12:07
     */
    void saveToken(String token);

    /**
     * <br> Description: 获取token
     * <br> Author:     lionszhang
     * <br> Date:        2017/8/10 12:07
     */
    String getToken();

    /**
     * <br> Description: 保存用户名
     * <br> Author:     lionszhang
     * <br> Date:        2017/8/21 19:31
     */
    void saveUsername(String name);
    /**
     * <br> Description: 保存用户名
     * <br> Author:      zhangqiang
     * <br> Date:        2017/8/21 19:31
     */
    void saveRealUsername(String realname);

    /**
     * <br> Description: 获取用户名
     * <br> Author:      lionszhang
     * <br> Date:        2017/8/21 19:32
     */
    String getUsername();

    /**
     * <br> Description: 保存用户真实名
     * <br> Author:     lionszhang
     * <br> Date:        2017/8/21 19:32
     */
    String getRealUsername();

    /**
     * <br> Description: 保存用户名
     * <br> Author:      lionszhang
     * <br> Date:        2017/8/21 19:32
     */



    void saveRealNameAuth(boolean isRealNameAuth);

    /**
     * <br> Description: 获取用户名
     * <br> Author:      lionszhang
     * <br> Date:        2017/8/21 19:32
     */
    boolean getRealNameAuth();

    /**
     * <br> Description: 获取用户名
     * <br> Author:     lionszhang
     * <br> Date:        2017/8/21 19:32
     */
    void saveRiskEval(boolean isRiskEval);

    /**
     * <br> Description: 获取用户名
     * <br> Author:     lionszhang
     * <br> Date:        2017/8/21 19:32
     */
    boolean getRiskEval();
}
