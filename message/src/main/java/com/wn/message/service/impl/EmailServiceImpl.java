package com.wn.message.service.impl;

import com.wn.common.entry.EmailTextEntry;
import com.wn.message.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.message.service
 * @Author: 廖刚
 * @CreateTime: 2020-06-02 16:25
 * @Description:
 */
@Component
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;


    public  void sendEmailText(EmailTextEntry emailTextEntry){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(emailTextEntry.getTo());
        simpleMailMessage.setSubject("eureka服务通知");
        simpleMailMessage.setText(emailTextEntry.getContent());
        javaMailSender.send(simpleMailMessage);

    }




}
