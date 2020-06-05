package com.wn.message.service;

import com.wn.common.entry.EmailTextEntry;

/**
 * @BelongsProject: cloud_base_4
 * @BelongsPackage: com.wn.message.service
 * @Author: 廖刚
 * @CreateTime: 2020-06-03 22:58
 * @Description:
 */
public interface EmailService {

    void sendEmailText(EmailTextEntry emailTextEntry);
}
