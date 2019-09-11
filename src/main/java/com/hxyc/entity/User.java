/*
 * @(#)User.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 上午11:28:16 $
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName;
    private String passWord;
    private Integer status;
    private Date createtime;
    private String publickey;
    private String privatekey;
    private String salt;
    private Integer lv;
    private Integer Identity;
    private String phone;
    private String realName;
    private String nickName;
    private String idCard;
    private String email;

    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Returns the userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            The userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return Returns the passWord.
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord
     *            The passWord to set.
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * @return Returns the status.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     *            The status to set.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return Returns the createtime.
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     *            The createtime to set.
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return Returns the publickey.
     */
    public String getPublickey() {
        return publickey;
    }

    /**
     * @param publickey
     *            The publickey to set.
     */
    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    /**
     * @return Returns the privatekey.
     */
    public String getPrivatekey() {
        return privatekey;
    }

    /**
     * @param privatekey
     *            The privatekey to set.
     */
    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    /**
     * @return Returns the salt.
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     *            The salt to set.
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return Returns the lv.
     */
    public Integer getLv() {
        return lv;
    }

    /**
     * @param lv
     *            The lv to set.
     */
    public void setLv(Integer lv) {
        this.lv = lv;
    }

    /**
     * @return Returns the identity.
     */
    public Integer getIdentity() {
        return Identity;
    }

    /**
     * @param identity
     *            The identity to set.
     */
    public void setIdentity(Integer identity) {
        Identity = identity;
    }

    /**
     * @return Returns the phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            The phone to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return Returns the realName.
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName
     *            The realName to set.
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * @return Returns the nickName.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     *            The nickName to set.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return Returns the idCard.
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     *            The idCard to set.
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return Returns the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", status=" + status
                + ", createtime=" + createtime + ", publickey=" + publickey + ", privatekey=" + privatekey + ", salt="
                + salt + ", lv=" + lv + ", Identity=" + Identity + ", phone=" + phone + ", realName=" + realName
                + ", nickName=" + nickName + ", idCard=" + idCard + ", email=" + email + "]";
    }

}
