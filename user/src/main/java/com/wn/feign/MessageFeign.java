package com.wn.feign;

import com.wn.common.entry.EmailTextEntry;
import com.wn.common.entry.MyParam;
import com.wn.common.entry.MyRsp;
import com.wn.common.entry.PhoneMsgEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.feign
 * @Author: 廖刚
 * @CreateTime: 2020-06-03 19:09
 * @Description:
 */
@FeignClient(value = "message")
public interface MessageFeign {

    @PostMapping("/sendEmailText")
    MyRsp sendEmailText(EmailTextEntry emailTextEntry);

    //发验证码的feign
    @PostMapping(value = "/sendPhoneMsg",consumes = "application/json",produces = "application/json")
    MyRsp sendPhoneMsg(MyParam<PhoneMsgEntity> param);
}
