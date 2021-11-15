package com.zhangk.desdemo.entity;

import java.io.Serializable;

/**
 * 数据库加解密demo
(DesDemo)实体类
 *
 * @author zhangk
 * @since 2021-11-15 15:26:43
 */
public class DesDemo implements Serializable {
    private static final long serialVersionUID = 219409881430188477L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String userName;
    /**
     * 电话
     */
    private String userPhone;
    /**
     * 地址
     */
    private String userAddress;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

}

