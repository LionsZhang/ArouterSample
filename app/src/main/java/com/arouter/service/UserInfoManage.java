package com.arouter.service;

import java.lang.ref.SoftReference;

/**
 * @author: lionszhang
 * @Filename: UserInfoManage
 * @Description: 用户信息管理服务
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/6/8 16:04
 */

class UserInfoManage {
    /**
     * 用户信息管理类
     */
    private static UserInfoManage mUserInfoManage;
    /**
     * UserInfo信息管理
     */
    private SoftReference<IUserInfoField> mSoftIUserInfoField;

    /**
     * 构造方法
     */
    private UserInfoManage() {
    }

    /**
     * 获取用户信息管理类
     *
     * @return UserInfoManage
     */
    protected static UserInfoManage getInstance() {
        if (mUserInfoManage == null) {
            synchronized (UserInfoManage.class) {
                if (mUserInfoManage == null) {
                    mUserInfoManage = new UserInfoManage();
                }
            }
        }
        return mUserInfoManage;
    }

    /**
     * 重置当前登录账号 （必须调用）所有与账号切换数据变更相关的管理类必须重新初始化
     */
    protected void reSetAtPresentAccount() {
        mSoftIUserInfoField = null;
    }

    /**
     * 获取UserInfo信息管理
     *
     * @return IUserInfoField
     */
    protected IUserInfoField getUserInfoField() {
        if (getSoftReferenceObject(mSoftIUserInfoField) == null) {
            synchronized (UserInfoManage.class) {
                if (getSoftReferenceObject(mSoftIUserInfoField) == null) {
//                    mSoftIUserInfoField =
//                            new SoftReference<IUserInfoField>(new UserInfoField());
                }
            }
        }
        return getSoftReferenceObject(mSoftIUserInfoField);
    }




    /**
     * @param mSoftReference SoftReference
     * @param <T>            T
     * @return T
     */
    private <T> T getSoftReferenceObject(SoftReference<T> mSoftReference) {
        return mSoftReference == null ? null : mSoftReference.get();
    }
}
