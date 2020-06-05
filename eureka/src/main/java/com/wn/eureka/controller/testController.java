package com.wn.eureka.controller;

import com.wn.common.entry.EmailTextEntry;
import com.wn.eureka.feign.MessageFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.eureka.controller
 * @Author: 廖刚
 * @CreateTime: 2020-06-02 21:34
 * @Description:
 */
@RestController
public class testController {
    @Autowired
    private MessageFeign messageFeign;

    @RequestMapping("test")
    public String test(){

        messageFeign.sendEmailText(new EmailTextEntry("liaog100@163.com","ddd"));
        return "123";
    }
}
