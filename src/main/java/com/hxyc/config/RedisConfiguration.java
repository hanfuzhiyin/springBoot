/*
 * @(#)RedisConfiguration.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.config;

import java.lang.reflect.Method;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import com.hxyc.config.common.constant.BaseConstant;
import com.hxyc.message.RedisMessage;

/**
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 上午10:51:22 $
 */
@Configuration
@EnableCaching // 开启注解
//maxInactiveIntervalInSeconds:session的统一过期时间,默认是1800秒过期，这里测试修改为60秒
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800) // 注解，开启redis集中session管理
public class RedisConfiguration extends CachingConfigurerSupport {

    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    /**
     * redis作为缓存
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory).build();
        return redisCacheManager;
    }

    /**
     * @Description: 防止redis入库序列化乱码的问题
     * @return 返回类型
     */
    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);// key序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // value序列化

        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 在springboot中使用spring-session的时候， 在不同的域名下面需要配置cookie主域否则session共享不生效
     *
     * @return
     */
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        // cookie名字
        defaultCookieSerializer.setCookieName("sessionId");
        // 不同子域时设置
        // defaultCookieSerializer.setDomainName("xxx.com");
        // 设置各web应用返回的cookiePath一致
        defaultCookieSerializer.setCookiePath("/");
        return defaultCookieSerializer;
    }

    /**
     * 创建连接工厂
     *
     * @param connectionFactory
     * @param adapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
            MessageListenerAdapter adapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(adapter, new PatternTopic(BaseConstant.REDIS_MESSAGE_KEY));
        return container;
    }

    /**
     * @param message
     * @return
     */
    @Bean
    public MessageListenerAdapter adapter(RedisMessage message) {
        // onMessage 如果RedisMessage 中 没有实现接口，这个参数必须跟RedisMessage中的读取信息的方法名称一样
        return new MessageListenerAdapter(message, "onMessage");
    }

}
