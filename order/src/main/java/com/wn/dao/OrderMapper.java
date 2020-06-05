package com.wn.dao;

import com.wn.common.entry.Order;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.dao
 * @Author: 廖刚
 * @CreateTime: 2020-06-02 10:31
 * @Description:
 */
@Mapper
public interface OrderMapper {

    List<Order> queryByPage(Order order);
}
