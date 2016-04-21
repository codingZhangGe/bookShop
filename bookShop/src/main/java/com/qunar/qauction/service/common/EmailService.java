package com.qunar.qauction.service.common;

import com.qunar.qauction.model.common.MailContent;

import java.util.List;

/**
 * Created by liuyanjiang on 16-4-19.
 */
public interface EmailService {
    public void sendMail(final MailContent content);

    public void sendMails(List<MailContent> mailContents);
}
