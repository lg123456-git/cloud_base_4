package com.wn.feign;

import com.wn.common.entry.EmailTextEntry;
import com.wn.common.entry.MyParam;
import com.wn.common.entry.MyRsp;
import com.wn.common.entry.PhoneMsgEntity;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.feign
 * @Author: 廖刚
 * @CreateTime: 2020-06-03 19:27
 * @Description:
 */
@Component
public class MessageFeignFallback implements MessageFeign{
    @Override
    public MyRsp sendEmailText(EmailTextEntry emailTextEntry) {

        MyRsp myRsp = MyRsp.error().code(500000).msg("消息服务正在忙碌，请您稍后访问。");
        return myRsp;
    }

    @Override
    public MyRsp sendPhoneMsg(MyParam<PhoneMsgEntity> param) {
        MyRsp myRsp = MyRsp.error().code(500000).msg("消息服务正在忙碌，请您稍后访问。");
        return myRsp;
    }
}