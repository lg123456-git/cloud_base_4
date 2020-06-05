package com.wn.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wn.common.entry.MyParam;
import com.wn.common.entry.Order;
import com.wn.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.service
 * @Author: 廖刚
 * @CreateTime: 2020-06-02 10:33
 * @Description:
 */
@Service
public class OrderServiceImpl implements  OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public PageInfo<Order> queryByPage(MyParam<Order> myParam) {
        /**
         * 排序规则
         */
        for(String parm:myParam.getPageParam()){
            PageHelper.orderBy(parm);
        }
        //PageHelper.orderBy("createTime desc");
        PageHelper.startPage(myParam.getMyPage().getPageNum(),myParam.getMyPage().getPageSize());
        List<Order> orderList = orderMapper.queryByPage(myParam.getT());
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList);
        return orderPageInfo;
    }


}
