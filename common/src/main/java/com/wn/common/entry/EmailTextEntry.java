package com.wn.common.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.common.entry
 * @Author: 廖刚
 * @CreateTime: 2020-06-02 16:16
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailTextEntry {

    private String to;
    private String content;


    public static EmailTextEntry setToandContent(String to,String content){
        EmailTextEntry emailTextEntry = new EmailTextEntry();
        emailTextEntry.setTo(to);
        emailTextEntry.setContent(content);
        return  emailTextEntry;
    }


}
