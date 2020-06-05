package com.wn.service.impl;

import com.wn.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.message.service.impl
 * @Author: 廖刚
 * @CreateTime: 2020-06-03 23:48
 * @Description:
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;




    /**
     * 对redis中字符串设置有效时间
     * @param key 键
     * @param value 值
     * @param expire 有效期时间
     */
    @Override
    public void setExpire(String key, String value, long expire) {
        try {
            //将字符串存入redis中
            redisTemplate.opsForValue().set(key, value);
            //设置这个字符串的有效期，单位是毫秒
            redisTemplate.expire(key,expire, TimeUnit.MILLISECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 获取数据中字符串形式的键值
     * @param key
     * @return
     */
    public Object getKey(String key) {

        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            return operations.get(key);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
