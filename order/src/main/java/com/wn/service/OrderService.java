package com.wn.service;

import com.github.pagehelper.PageInfo;
import com.wn.common.entry.MyParam;
import com.wn.common.entry.Order;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.service
 * @Author: 廖刚
 * @CreateTime: 2020-06-02 10:32
 * @Description:
 */
public interface OrderService {

    PageInfo<Order> queryByPage(MyParam<Order> myParam);
}
