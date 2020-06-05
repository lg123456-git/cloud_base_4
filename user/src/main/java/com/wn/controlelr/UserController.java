package com.wn.controlelr;


import com.wn.common.entry.MyParam;
import com.wn.common.entry.MyRsp;
import com.wn.common.entry.Order;
import com.wn.common.entry.PhoneMsgEntity;
import com.wn.feign.MessageFeign;
import com.wn.feign.OrderFeign;
import com.wn.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.controlelr
 * @Author: 廖刚
 * @CreateTime: 2020-06-01 21:05
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private OrderFeign orderFeign;

    @Autowired
    private MessageFeign messageFeign;

    @Autowired
    private RedisService redisService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/visitOrder")
    public MyRsp visitOrder(@RequestBody Order order){
        MyRsp MyRsp = orderFeign.getOrder(order);

        return MyRsp;
    }

    @GetMapping("/visitHello")
    public MyRsp visitHello(){
        MyRsp myRsp = orderFeign.visitHello();
        return myRsp;
    }

    /**
     * 发送验证码,并且存入redis数据库
     */
    @PostMapping("/getPhoneCode")
    public MyRsp getPhoneCode(@RequestBody MyParam<PhoneMsgEntity> param){
        System.out.println(param);
        //调用feign中的方法，发送验证码，并且存入数据库中
        MyRsp myRsp = messageFeign.sendPhoneMsg(param);
        return myRsp;
    }

    /**
     * 短信验证码登录
     */
    @PostMapping("/loginWithPhoneCode")
    public MyRsp loginWithPhoneCode(@RequestBody MyParam<PhoneMsgEntity> param){
        //首先根据输入的手机号作为键获取redis中的验证码
        String code = (String)redisService.getKey(param.getT().getPhoneNum());
        //用户输入的验证码和数据库中做匹配
        if(code.equals(param.getT().getCode())){//通过验证
            //删除redis中的这个键值对
            redisTemplate.delete(param.getT().getPhoneNum());
            return MyRsp.success("登录成功");
        }else{
            return MyRsp.success("登录失败");
        }
    }
}
