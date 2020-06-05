package com.wn.common.entry;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.common.entry
 * @Author: 廖刚
 * @CreateTime: 2020-06-03 10:11
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPage {

    @NotNull
    private Integer pageNum;

    @NotNull
    private Integer pageSize;




}
