package com.wn.message.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.wn.message.service.PhoneMsgService;
import com.wn.message.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.message.service.impl
 * @Author: 廖刚 测试
 * @CreateTime: 2020-06-03 23:00
 * @Description:
 */
@Service
public class PhoneMsgServiceImpl implements PhoneMsgService {

    @Autowired
    private RedisService redisService;

    @Override
    public void sendPhoneMsg(String phoneNum) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G3r15F3Ybkh9NTfFSt4", "7vmyM5bxgwcySyH7GAalJl8IoMBB2h");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "刚哥课堂");
        request.putQueryParameter("TemplateCode", "SMS_192230858");
        Random random = new Random();
        int num = random.nextInt(999999);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+num+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            //如果成功发送
            boolean isSuccess = response.getData().indexOf("OK")>-1;
            //判断如果发送短信成功，以手机号码为键，验证码为值，存入redis缓存中
            if(isSuccess){
                //向redis中存入手机号和验证码，并且设置有效期是5分钟
                redisService.setExpire(phoneNum,num+"",1000*60*5);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
