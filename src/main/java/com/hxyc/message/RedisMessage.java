/*
 * @(#)RedisMessage.java    Created on 2019年9月6日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月6日 下午2:44:37 $
 */
@Component
public class RedisMessage implements MessageListener {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
        String msg = serializer.deserialize(message.getBody());
        System.out.println("接收到的消息是：" + msg);
    }

}
