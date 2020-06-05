package com.wn.eureka.feign;

import com.wn.common.entry.EmailTextEntry;
import com.wn.common.entry.MyRsp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.eureka.feign
 * @Author: 廖刚
 * @CreateTime: 2020-06-02 16:37
 * @Description:
 */
@FeignClient(value = "message")
public interface MessageFeign {

    @PostMapping("/sendEmailText")
    MyRsp sendEmailText(EmailTextEntry emailTextEntry);

}
