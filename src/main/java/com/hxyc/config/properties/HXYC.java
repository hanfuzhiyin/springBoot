/*
 * @(#)HXYC.java    Created on 2019年9月10日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月10日 下午3:11:02 $
 */

@Configuration
@ConfigurationProperties(prefix = "hxyc", ignoreUnknownFields = false)
@PropertySource(value = "classpath:config/hxyc.properties", encoding = "UTF-8")
@Component
public class HXYC {
    private String version;// 版本号
    private String footInfo;// 页脚信息
    private String platFormName;// 平台名称
    private String domain;// 主域名

    /**
     * @return Returns the version.
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     *            The version to set.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return Returns the footInfo.
     */
    public String getFootInfo() {
        return footInfo;
    }

    /**
     * @param footInfo
     *            The footInfo to set.
     */
    public void setFootInfo(String footInfo) {
        this.footInfo = footInfo;
    }

    /**
     * @return Returns the platFormName.
     */
    public String getPlatFormName() {
        return platFormName;
    }

    /**
     * @param platFormName
     *            The platFormName to set.
     */
    public void setPlatFormName(String platFormName) {
        this.platFormName = platFormName;
    }

    /**
     * @return Returns the domain.
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain
     *            The domain to set.
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

}
