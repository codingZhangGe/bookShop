package com.qunar.qauction.job;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import qunar.tc.qschedule.config.QSchedule;
import qunar.tc.schedule.Parameter;

import com.qunar.qauction.common.exceptions.PutOnFailureException;
import com.qunar.qauction.model.admin.dto.ResultOfPutOn;
import com.qunar.qauction.model.common.MailContent;
import com.qunar.qauction.service.common.EmailService;
import com.qunar.qauction.service.common.ItemTakeOffService;

/**
 * 自动上架未竞拍的拍卖商品
 * 
 * @author yunfeng.yang created on 16-4-20
 * @version 1.0
 */
@Component
public class ItemAutoStartAuctionJob {

    private static Logger LOGGER = LoggerFactory.getLogger(ItemAutoStartAuctionJob.class);

    @Resource
    private ItemTakeOffService itemTakeOffService;

    @Resource
    private EmailService emailService;

    @QSchedule("itemAutoStartAuctionJob")
    public void startItemAuctionAutomatic(Parameter parameter) {
        List<String> itemIds = itemTakeOffService.selectBecomeDueItems();
        putOnItems(itemIds);
    }

    private void putOnItems(List<String> itemIds) {
        for (String itemId : itemIds) {
            ResultOfPutOn resultOfPutOn = itemTakeOffService.putOnItem(itemId);
            dealResultOfPutOn(resultOfPutOn);
        }
    }

    private boolean dealResultOfPutOn(ResultOfPutOn resultOfPutOn) {
        if (!resultOfPutOn.getResult()) {
            LOGGER.warn("下架产品失败{}", new PutOnFailureException());
            return false;
        }
        String sellerQtalk = resultOfPutOn.getSellerQtalk();
        String contentToSeller = "亲爱的小驼, " + sellerQtalk + ", 您的竞拍商品" + resultOfPutOn.getItemName() + "已经开始竞拍, 当前价格是:"
                + resultOfPutOn.getCurrentPrice() + ", 你的预期价格是:" + resultOfPutOn.getReversePrice() + ", Q拍祝您竞拍愉快";
        sendEmail(sellerQtalk, contentToSeller);
        return true;
    }

    private void sendEmail(String qtalk, String content) {
        MailContent mailContent = new MailContent();
        mailContent.setContent(content);
        mailContent.setToEmail(qtalk);
        emailService.sendMail(mailContent);
    }
}
