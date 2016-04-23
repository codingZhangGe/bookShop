package com.qunar.qauction.service.common;

import com.qunar.qauction.model.admin.dto.ResultOfPutOn;
import com.qunar.qauction.model.admin.dto.ResultOfTakeOff;

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
