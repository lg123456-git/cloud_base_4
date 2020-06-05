package com.wn.message.controller;

import com.wn.common.entry.EmailTextEntry;
import com.wn.common.entry.MyRsp;
import com.wn.message.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.message.controller
 * @Author: 廖刚
 * @CreateTime: 2020-06-02 16:31
 * @Description:
 */
@RestController
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;



    @PostMapping("/sendEmailText")
    public MyRsp sendEmailText(@RequestBody EmailTextEntry emailTextEntry) {
        System.out.println("------" + emailTextEntry);
        int i = 1/0;
        emailService.sendEmailText(emailTextEntry);
        return MyRsp.success("发送成功！");
    }




}
