package com.xupt.bookshop.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xupt.bookshop.common.utils.UUIDGenerator;
import com.xupt.bookshop.dao.AdministratorDao;
import com.xupt.bookshop.model.admin.dto.ResultOfPutOn;
import com.xupt.bookshop.model.admin.dto.ResultOfTakeOff;
import com.xupt.bookshop.model.common.FinishedItemInfo;
import com.xupt.bookshop.model.common.UnfinishedItemDynamicInfo;
import com.xupt.bookshop.model.common.UnfinishedItemFixedInfo;
import com.xupt.bookshop.model.enums.State;
import com.xupt.bookshop.service.common.ItemTakeOffService;

/**
 * @author yunfeng.yang created on 16-4-20
 * @version 1.0
 */
@Service
public class ItemTakeOffServiceImpl implements ItemTakeOffService {

    @Resource
    private AdministratorDao administratorDao;

    @Override
    public List<String> selectOverdueItemIds() {
        //TODO
        return null;
    }

    @Override
    public List<String> selectBecomeDueItems() {
        //TODO
        return null;
    }

    @Override
    public ResultOfPutOn putOnItem(String itemId) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ResultOfTakeOff takeOffItem(String itemId) {
        UnfinishedItemFixedInfo unfinishedItemFixedInfo = administratorDao.queryUnfinishedItemFixedInfoById(itemId);
        ResultOfTakeOff resultOfTakeOff = new ResultOfTakeOff();
        if (State.FAILURE_AUCTION == unfinishedItemFixedInfo.getState()
                || State.SUCCESS_AUCTION == unfinishedItemFixedInfo.getState()) {
            resultOfTakeOff.setResult(false);
            return resultOfTakeOff;
        }
        UnfinishedItemDynamicInfo unfinishedItemDynamicInfo = administratorDao
                .queryUnfinishedItemDynamicInfoById(itemId);
        FinishedItemInfo finishedItemInfo = unfinishedItemInfoToFinishedInfoWithFailureState(unfinishedItemFixedInfo,
                unfinishedItemDynamicInfo);
        administratorDao.addFinishedItem(finishedItemInfo);
        //删除过期Item
        administratorDao.deleteUnfinishedItemDynamicInfoByItemId(itemId);
        administratorDao.deleteUnfinishedItemFixedInfoByItemId(itemId);
        resultOfTakeOff.setResult(true);
        resultOfTakeOff.setBidderQtalk(unfinishedItemDynamicInfo.getCurrentBidderQtalk());
        resultOfTakeOff.setSellerQtalk(unfinishedItemFixedInfo.getSellerQtalk());
        resultOfTakeOff.setItemState(unfinishedItemFixedInfo.getState());
        resultOfTakeOff.setItemName(unfinishedItemFixedInfo.getItemName());
        return resultOfTakeOff;
    }

    private FinishedItemInfo unfinishedItemInfoToFinishedInfoWithFailureState(
            UnfinishedItemFixedInfo unfinishedItemFixedInfo, UnfinishedItemDynamicInfo unfinishedItemDynamicInfo) {
        FinishedItemInfo finishedItemInfo = new FinishedItemInfo();
        finishedItemInfo.setItemId(UUIDGenerator.getUUID());
        finishedItemInfo.setState(State.FAILURE_AUCTION);
        finishedItemInfo.setItemId(unfinishedItemFixedInfo.getItemId());
        finishedItemInfo.setItemName(unfinishedItemFixedInfo.getItemName());
        finishedItemInfo.setOldDegree(unfinishedItemFixedInfo.getOldDegree());
        finishedItemInfo.setCategoryId(unfinishedItemFixedInfo.getCategoryId());
        finishedItemInfo.setSellerQtalk(unfinishedItemFixedInfo.getSellerQtalk());
        finishedItemInfo.setDescription(unfinishedItemFixedInfo.getDescription());
        finishedItemInfo.setStartTime(unfinishedItemFixedInfo.getStartTime());
        finishedItemInfo.setEndTime(unfinishedItemFixedInfo.getEndTime());
        finishedItemInfo.setStartPrice(unfinishedItemFixedInfo.getStartPrice());
        finishedItemInfo.setStepPrice(unfinishedItemFixedInfo.getStepPrice());
        finishedItemInfo.setReservePrice(unfinishedItemFixedInfo.getReservePrice());
        finishedItemInfo.setFinalPrice(unfinishedItemDynamicInfo.getCurrentPrice());
        finishedItemInfo.setAuctionCount(unfinishedItemDynamicInfo.getAuctionCount());
        finishedItemInfo.setSubscriptionCount(unfinishedItemDynamicInfo.getSubscriptionCount());
        finishedItemInfo.setBrowseCount(unfinishedItemDynamicInfo.getBrowseCount());
        return finishedItemInfo;
    }
}
