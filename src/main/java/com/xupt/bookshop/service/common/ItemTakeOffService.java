package com.xupt.bookshop.service.common;

import com.xupt.bookshop.model.admin.dto.ResultOfPutOn;
import com.xupt.bookshop.model.admin.dto.ResultOfTakeOff;

import java.util.List;

/**
 * @author yunfeng.yang created on 16-4-20
 * @version 1.0
 */
public interface ItemTakeOffService {

    ResultOfTakeOff takeOffItem(String itemId);

    List<String> selectOverdueItemIds();

    List<String> selectBecomeDueItems();

    ResultOfPutOn putOnItem(String itemId);
}
