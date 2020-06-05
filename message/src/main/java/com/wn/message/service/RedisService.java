package com.wn.message.service;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.message.service
 * @Author: 廖刚
 * @CreateTime: 2020-06-03 23:47
 * @Description:
 */
public interface RedisService {

    //对redis中字符串的数据设置有效期
    void setExpire(String key,String value,long expire);
}
