package com.wn.common.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.common.entry
 * @Author: 廖刚
 * @CreateTime: 2020-06-03 10:13
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyParam<T> {

    private MyPage myPage;//分页参数，里面包含pageNum和pageSize


    private String[] pageParam;//需要排序的参数数组

    private T t;

}
