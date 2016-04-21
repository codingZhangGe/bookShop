package com.qunar.qauction.model.common;

import com.qunar.qauction.common.Constants;

/**
 *
 * Created by liuyanjiang on 16-4-14.
 */
public class MailContent {
    private String toEmail;
    private String fromEmail = Constants.DEFAULT_FROM;// 默认值
    private String content;
    private String subject = Constants.DEFAULT_SUBJECT;// 默认值

    public MailContent() {

    }

    public MailContent(String toEmail, String content, String subject) {
        this.toEmail = toEmail;
        this.content = content;
        this.subject = subject;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getContent() {
        return content + Constants.DEFAULT_STRING + Constants.DEFAULT_LINK;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
