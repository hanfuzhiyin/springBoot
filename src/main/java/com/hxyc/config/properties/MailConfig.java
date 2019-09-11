/*
 * @(#)MailConfig.java    Created on 2019年9月11日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月11日 上午10:29:35 $
 */
@Configuration
@PropertySource(value = "classpath:config/mailConfig.properties", encoding = "UTF-8")
@Component
public class MailConfig {
    public static String host;
    public static Integer port;
    public static String userName;
    public static String passWord;
    public static String emailForm;
    public static String timeout;
    public static String personal;
    public static String html;
    public static String subject;

    /**
     * @return Returns the host.
     */
    public static String getHost() {
        return host;
    }

    /**
     * @param host
     *            The host to set.
     */
    @Value("${mail.host}")
    public void setHost(String host) {
        MailConfig.host = host;
    }

    /**
     * @return Returns the port.
     */
    public static Integer getPort() {
        return port;
    }

    /**
     * @param port
     *            The port to set.
     */
    @Value("${mail.port}")
    public void setPort(Integer port) {
        MailConfig.port = port;
    }

    /**
     * @return Returns the userName.
     */
    public static String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            The userName to set.
     */
    @Value("${mail.userName}")
    public void setUserName(String userName) {
        MailConfig.userName = userName;
    }

    /**
     * @return Returns the passWord.
     */
    public static String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord
     *            The passWord to set.
     */
    @Value("${mail.passWord}")
    public void setPassWord(String passWord) {
        MailConfig.passWord = passWord;
    }

    /**
     * @return Returns the emailForm.
     */
    public static String getEmailForm() {
        return emailForm;
    }

    /**
     * @param emailForm
     *            The emailForm to set.
     */
    @Value("${mail.emailForm}")
    public void setEmailForm(String emailForm) {
        MailConfig.emailForm = emailForm;
    }

    /**
     * @return Returns the timeout.
     */
    public static String getTimeout() {
        return timeout;
    }

    /**
     * @param timeout
     *            The timeout to set.
     */
    @Value("${mail.timeout}")
    public void setTimeout(String timeout) {
        MailConfig.timeout = timeout;
    }

    /**
     * @return Returns the personal.
     */
    public static String getPersonal() {
        return personal;
    }

    /**
     * @param personal
     *            The personal to set.
     */
    @Value("${mail.personal}")
    public void setPersonal(String personal) {
        MailConfig.personal = personal;
    }

    /**
     * @return Returns the html.
     */
    public static String getHtml() {
        return html;
    }

    /**
     * @param html
     *            The html to set.
     */
    @Value("${mail.html}")
    public void setHtml(String html) {
        MailConfig.html = html;
    }

    /**
     * @return Returns the subject.
     */
    public static String getSubject() {
        return subject;
    }

    /**
     * @param subject
     *            The subject to set.
     */
    @Value("${mail.subject}")
    public void setSubject(String subject) {
        MailConfig.subject = subject;
    }

}
