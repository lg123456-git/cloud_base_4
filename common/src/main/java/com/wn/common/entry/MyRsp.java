package com.wn.common.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.common.entry
 * @Author: 廖刚
 * @CreateTime: 2020-06-01 21:16
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyRsp {

    private Integer code;

    private String msg;

    private Object content;

    public MyRsp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MyRsp success(Object content){

        return new MyRsp(20000,"发送成功",content);
    }


    public static MyRsp error(){
        return new MyRsp(50000,"发送失败");
    }

    /**
     * 修改状态码
     * @param code
     * @return
     */
    public MyRsp code(Integer code){
        this.code = code;
        return this;
    }

    public MyRsp msg(String msg){
        this.msg = msg;
        return this;
    }

}
