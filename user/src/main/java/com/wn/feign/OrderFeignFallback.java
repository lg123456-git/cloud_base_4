package com.wn.feign;

import com.wn.common.entry.MyRsp;
import com.wn.common.entry.Order;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.feign
 * @Author: 廖刚
 * @CreateTime: 2020-06-03 18:33
 * @Description:
 */
@Component
public class OrderFeignFallback implements OrderFeign {
    @Override
    public MyRsp getOrder(Order order) {
        return null;
    }

    @Override
    public MyRsp visitHello() {
        MyRsp msg = MyRsp.error().code(50000).msg("订单服务停用，请稍后再试");
        return msg;
    }
}
