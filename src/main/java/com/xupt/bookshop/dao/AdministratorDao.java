package com.xupt.bookshop.dao;

import java.util.List;

import com.xupt.bookshop.model.admin.Administrator;
import com.xupt.bookshop.model.admin.FinishedItemInfoForQuery;
import com.xupt.bookshop.model.admin.UnfinishedItemForQuery;
import com.xupt.bookshop.model.common.Category;
import com.xupt.bookshop.model.common.UnfinishedItemFixedInfo;
import com.xupt.bookshop.model.enums.State;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.xupt.bookshop.model.common.FinishedItemInfo;
import com.xupt.bookshop.model.common.UnfinishedItemDynamicInfo;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
@Repository
public interface AdministratorDao {
    List<FinishedItemInfoForQuery> queryFinishedItemList(RowBounds rowBounds);

    List<UnfinishedItemForQuery> queryUnfinishedItemList(RowBounds rowBounds, @Param("state") State state);

    void addAdministrator(@Param("administrator") Administrator administrator);

    void addCategory(@Param("cart") Category category);

    List<Category> queryAllCategories(RowBounds rowBounds);

    UnfinishedItemFixedInfo queryUnfinishedItemFixedInfoById(@Param("itemId") String itemId);

    UnfinishedItemDynamicInfo queryUnfinishedItemDynamicInfoById(@Param("itemId") String itemId);

    void addFinishedItem(@Param("finishedItemInfo") FinishedItemInfo finishedItemInfo);

    Administrator selectAdminByQtalk(@Param("qtalk")String qtalk);

    void deleteUnfinishedItemFixedInfoByItemId(@Param("itemId")String itemId);

    void deleteUnfinishedItemDynamicInfoByItemId(@Param("itemId")String itemId);
}
