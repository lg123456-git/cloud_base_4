package com.wn.controller;

import com.github.pagehelper.PageInfo;
import com.wn.common.entry.EmailTextEntry;
import com.wn.common.entry.MyParam;
import com.wn.common.entry.MyRsp;
import com.wn.common.entry.Order;
import com.wn.feign.MessageFeign;
import com.wn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.controller
 * @Author: 廖刚
 * @CreateTime: 2020-06-01 20:59
 * @Description:
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MessageFeign messageFeign;

    @Value("${spring.application.name}")
    private String AppName;

    @Value("${server.port}")
    private String port;

    @PostMapping("/getOrder")
    public MyRsp getOrder(@RequestBody Order order){
        System.out.println(order);
        Order order1 = new Order(order.getOrderId(), order.getSummory(), new Date());
        return MyRsp.success(order1);
    }


    @PostMapping("/getByPage")
    public MyRsp getByPage(@RequestBody MyParam<Order> myParam){
        System.out.println(myParam);
        PageInfo<Order> orderPageInfo = orderService.queryByPage(myParam);
        return MyRsp.success(orderPageInfo);
    }


    @GetMapping("/hello")
    public MyRsp hello(){

        //int i = 1/0;
       // MyRsp myRsp = messageFeign.sendEmailText(new EmailTextEntry("liaog100@163.com", "测试"));
        return MyRsp.success("我是："+AppName+"我的端口号是："+port);
    }
}
