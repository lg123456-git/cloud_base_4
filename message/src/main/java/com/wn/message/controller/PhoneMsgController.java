package com.wn.message.controller;

import com.wn.common.entry.MyParam;
import com.wn.common.entry.MyRsp;
import com.wn.common.entry.PhoneMsgEntity;
import com.wn.message.service.PhoneMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.message.controller
 * @Author: 廖刚
 * @CreateTime: 2020-06-03 23:10
 * @Description:
 */
@RestController
public class PhoneMsgController {

    @Autowired
    private PhoneMsgService phoneMsgService;

    @PostMapping("/sendPhoneMsg")
    public MyRsp sendPhoneMsg(@RequestBody MyParam<PhoneMsgEntity> param){
        System.out.println(param);
        phoneMsgService.sendPhoneMsg(param.getT().getPhoneNum());

        return MyRsp.success("发送成功");
    }
}
