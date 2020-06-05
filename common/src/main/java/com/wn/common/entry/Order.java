package com.wn.common.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.common.entry
 * @Author: 廖刚
 * @CreateTime: 2020-06-01 21:14
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String orderId;

    private String summory;

    private Date createTime;
}
