package com.arouter.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author: lionszhang
 * @Filename:
 * @Description: 用户信息管理服务基类
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/6/9 10:25
 */

class UserBaseService implements IProvider {
    private UserInfoManage mUserInfoManage;

    /**
     * 服务初始化
     *
     * @param context Context
     */
    public void init(Context context) {
        mUserInfoManage = UserInfoManage.getInstance();
    }

    protected UserInfoManage getUserInfoManage() {
        return mUserInfoManage;
    }
}
