package com.qunar.qauction.service.common.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import com.qunar.qauction.common.Constants;
import com.qunar.qauction.service.common.EmailService;
import com.qunar.qauction.model.common.MailContent;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 *
 * Created by liuyanjiang on 16-4-19.
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Resource
    private JavaMailSender mailSender;
    @Resource
    private ThreadPoolTaskExecutor emailThreadPool;

    /**
     * 同步发送给单人邮件
     */
    public void sendMail(final MailContent content) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true,
                        Constants.DEFAULT_CHARSET_ENCODING);
                message.setTo(content.getToEmail());
                message.setFrom(content.getFromEmail());
                message.setSubject(content.getSubject());
                message.setText(content.getContent());
            }
        };
        mailSender.send(preparator);
    }

    /**
     * 并发发送给多人邮件
     */
    public void sendMails(List<MailContent> mailContents) {
        for (final MailContent content : mailContents) {
            emailThreadPool.execute(new SingleMail(content));
        }
    }

    /**
     * 内部类|调用单人发邮件功能
     */
    class SingleMail implements Runnable {
        private MailContent mail;

        public SingleMail(MailContent mail) {
            this.mail = mail;
        }

        @Override
        public void run() {
            sendMail(mail);
        }
    }
}
