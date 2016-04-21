package com.qunar.qauction.job;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import qunar.api.pojo.Money;
import qunar.tc.qschedule.config.QSchedule;
import qunar.tc.schedule.Parameter;

import com.qunar.qauction.common.exceptions.TakeOffFailureException;
import com.qunar.qauction.model.admin.dto.ResultOfTakeOff;
import com.qunar.qauction.model.common.MailContent;
import com.qunar.qauction.service.common.EmailService;
import com.qunar.qauction.service.common.ItemTakeOffService;

/**
 * 自动下架过期产品
 * 
 * @author yunfeng.yang created on 16-4-19
 * @version 1.0
 */
@Component
public class ItemAutoOffloadJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemAutoOffloadJob.class);

    @Resource
    private ItemTakeOffService itemTakeOffService;

    @Resource
    private EmailService emailService;

    @QSchedule("itemAutoOffloadJob")
    public void takeOffItemAutomatic(Parameter parameter) {
        List<String> itemIds = itemTakeOffService.selectOverdueItemIds();
        takeOffItemsByItemIds(itemIds);
    }

    private void takeOffItemsByItemIds(List<String> itemIds) {
        for (String itemId : itemIds) {
            ResultOfTakeOff resultOfTakeOff = itemTakeOffService.takeOffItem(itemId);
            dealWithResultOfTakeOff(resultOfTakeOff);
        }
    }

    private boolean dealWithResultOfTakeOff(ResultOfTakeOff resultOfTakeOff) {
        if (!resultOfTakeOff.getResult()) {
            LOGGER.warn("下架产品失败{}", new TakeOffFailureException());
            return false;
        }
        Money currentPrice = resultOfTakeOff.getCurrentPrice();
        Money reversePrice = resultOfTakeOff.getReversePrice();
        String sellerQtalk = resultOfTakeOff.getSellerQtalk();
        String itemName = resultOfTakeOff.getItemName();
        if (currentPrice.compareTo(reversePrice) < 0) {
            String contentToSeller = "亲爱的小驼, " + sellerQtalk + ", 您的竞拍商品" + itemName + "竞拍时间已到, 当前价格是:" + currentPrice
                    + ", 比你的预期价格:" + reversePrice + "还要低, 简直没有天理, 您可以选择重新拍卖, 或者留着该竞拍物品自己用";
            sendEmail(sellerQtalk, contentToSeller);
        } else {
            String buyerQtalk = resultOfTakeOff.getBidderQtalk();
            String contentToSeller = "亲爱的小驼, " + resultOfTakeOff.getSellerQtalk() + ", 您的竞拍商品" + itemName
                    + "已经被成功竞拍, 最终竞拍价格是:" + currentPrice + "竞拍成功的小驼是: " + buyerQtalk + "快和他/她联系吧!";
            String contentToBuyer = "亲爱的小驼, " + resultOfTakeOff.getSellerQtalk() + ",  您已经成功竞拍到商品" + itemName
                    + ", 该商品的卖家是: " + sellerQtalk;
            sendEmail(sellerQtalk, contentToSeller);
            sendEmail(buyerQtalk, contentToBuyer);
        }
        return true;
    }

    private void sendEmail(String qtalk, String content) {
        MailContent mailContent = new MailContent();
        mailContent.setContent(content);
        mailContent.setToEmail(qtalk);
        emailService.sendMail(mailContent);
    }
}
