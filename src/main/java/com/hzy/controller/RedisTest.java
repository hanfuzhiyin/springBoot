package com.hzy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.hzy.service.RedisService;

/**
 *
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午2:40:47 $
 */
@Controller
public class RedisTest {

    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    RedisService redisService;

    @GetMapping("testRedis")
    public String testRedis(ModelMap map) {
        // int redisConfigPort = redisConfig.getPort();
        // String s = RedisUtil.getInstance().strings().set("test", "redis-set");
        // System.out.println(redisConfig.getHost()+"$$$$"+redisConfig.getPort()+"$$$$"+3000+"$$$$"+redisConfig.getPassword());
        redisService.set("test:test1", "redis-set");
        redisService.set("test:test2", "redis-set2");
        redisService.set("test:test3", "redis-set3");
        log.info("key{},{},{}", "1", "2", "3");
        map.put("msg", "welcome to freemarker");
        return "index";
    }

    public static void main(String[] args) {

        // System.out.println(database);
        // System.out.println(database);
    }
}
