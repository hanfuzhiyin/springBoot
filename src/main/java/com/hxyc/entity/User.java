/*
 * @(#)User.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.entity;

import java.io.Serializable;

/**
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 上午11:28:16 $
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName;
    private String passWord;

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

}
