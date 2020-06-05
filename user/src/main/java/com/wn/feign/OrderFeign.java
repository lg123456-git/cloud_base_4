package com.wn.feign;

import com.wn.common.entry.MyRsp;
import com.wn.common.entry.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.feign
 * @Author: 廖刚
 * @CreateTime: 2020-06-01 21:01
 * @Description:
 */

@FeignClient(value = "order",fallback = OrderFeignFallback.class)
public interface OrderFeign {

    @PostMapping("getOrder")
    MyRsp getOrder(Order order);


    @GetMapping("hello")
    MyRsp visitHello();

}
