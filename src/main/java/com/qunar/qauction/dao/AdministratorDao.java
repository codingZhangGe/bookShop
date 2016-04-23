package com.qunar.qauction.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.qunar.qauction.model.common.FinishedItemInfo;
import com.qunar.qauction.model.common.UnfinishedItemDynamicInfo;
import com.qunar.qauction.model.common.UnfinishedItemFixedInfo;
import com.qunar.qauction.model.admin.Administrator;
import com.qunar.qauction.model.common.Category;
import com.qunar.qauction.model.admin.FinishedItemInfoForQuery;
import com.qunar.qauction.model.admin.UnfinishedItemForQuery;
import com.qunar.qauction.model.enums.State;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
@Repository
public interface AdministratorDao {
    List<FinishedItemInfoForQuery> queryFinishedItemList(RowBounds rowBounds);

    List<UnfinishedItemForQuery> queryUnfinishedItemList(RowBounds rowBounds, @Param("state") State state);

    void addAdministrator(@Param("administrator") Administrator administrator);

    void addCategory(@Param("category") Category category);

    List<Category> queryAllCategories(RowBounds rowBounds);

    UnfinishedItemFixedInfo queryUnfinishedItemFixedInfoById(@Param("itemId") String itemId);

    UnfinishedItemDynamicInfo queryUnfinishedItemDynamicInfoById(@Param("itemId") String itemId);

    void addFinishedItem(@Param("finishedItemInfo") FinishedItemInfo finishedItemInfo);

    Administrator selectAdminByQtalk(@Param("qtalk")String qtalk);

    void deleteUnfinishedItemFixedInfoByItemId(@Param("itemId")String itemId);

    void deleteUnfinishedItemDynamicInfoByItemId(@Param("itemId")String itemId);
}
