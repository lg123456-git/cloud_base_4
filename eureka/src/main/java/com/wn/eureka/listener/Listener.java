package com.wn.eureka.listener;

import com.wn.common.entry.EmailTextEntry;
import com.wn.eureka.feign.MessageFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.listener
 * @Author: 廖刚
 * @CreateTime: 2020-06-02 14:45
 * @Description:
 */
@Component
public class Listener {

    @Autowired
    private MessageFeign messageFeign;

    @EventListener
    public void listen1(EurekaInstanceCanceledEvent event){
        String appName = event.getAppName();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        System.out.println("服务下线通知：服务名称："+appName+" 服务详情"+event.toString()
        +"下线时间："+ simpleDateFormat.format(new Date(event.getTimestamp())));
        if (appName.equalsIgnoreCase("user")){
            //发送邮件
            System.out.println(appName +"服务挂了");
            EmailTextEntry textEntry = EmailTextEntry.setToandContent("liaog100@163.com", "服务下线通知：服务名称：" + appName
                    +"下线时间："+ simpleDateFormat.format(new Date(event.getTimestamp()))+ " 服务详情" + event.toString());
            System.out.println(textEntry);
            messageFeign.sendEmailText(textEntry);
        }
    }

    @EventListener
    public void listen2(EurekaInstanceRegisteredEvent event){
        System.out.println("服务注册通知：服务名称"+event.getInstanceInfo().getAppName()+"服务详情："+
                event.toString());

    }

    @EventListener
    public void listen3(EurekaInstanceRenewedEvent event){
        System.out.println("服务续约通知：服务名称"+event.getAppName()+
                " 服务详情："+event.toString());
    }


    public void listen4(EurekaRegistryAvailableEvent event){

        System.out.println("服务器eureka启动通知：服务名称"+event.toString());
    }

}
