package com.qunar.qauction.service.admin;

import java.util.List;

import com.qunar.qauction.model.admin.Administrator;
import com.qunar.qauction.model.admin.FinishedItemInfoForQuery;
import com.qunar.qauction.model.admin.UnfinishedItemForQuery;
import com.qunar.qauction.model.admin.dto.ResultOfTakeOff;
import com.qunar.qauction.model.common.Category;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
public interface AdministratorService {

    List<FinishedItemInfoForQuery> queryFinishedItemList(Integer currentPage, Integer pageSize);

    List<UnfinishedItemForQuery> queryUnStartItemList(Integer currentPage, Integer pageSize);

    void addAdministrator(Administrator administrator);

    void addCategory(Category category);

    List<Category> queryAllCategories(Integer currentPage, Integer pageSize);

    List<UnfinishedItemForQuery> queryDuringAuctionItemList(Integer currentPage, Integer pageSize);

    Administrator selectAdminByQtalk(String qtalk);
}
