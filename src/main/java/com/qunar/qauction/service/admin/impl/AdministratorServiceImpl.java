package com.qunar.qauction.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import com.qunar.qauction.common.Constants;
import com.qunar.qauction.dao.AdministratorDao;
import com.qunar.qauction.model.admin.dto.ResultOfTakeOff;
import com.qunar.qauction.service.admin.AdministratorService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qunar.qauction.common.utils.UUIDGenerator;
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
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Resource
    private AdministratorDao administratorDao;

    @Override

    public List<FinishedItemInfoForQuery> queryFinishedItemList(Integer currentPage, Integer pageSize) {
        // currentPage从前端传来的时候从1开始, 所以在这减一
        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);
        return administratorDao.queryFinishedItemList(rowBounds);
    }

    @Override
    public List<UnfinishedItemForQuery> queryUnStartItemList(Integer currentPage, Integer pageSize) {
        // currentPage从前端传来的时候从1开始, 所以在这减一
        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);
        return administratorDao.queryUnfinishedItemList(rowBounds, State.UN_START_AUCTION);
    }

    @Override
    public List<UnfinishedItemForQuery> queryDuringAuctionItemList(Integer currentPage, Integer pageSize) {
        // currentPage从前端传来的时候从1开始, 所以在这减一
        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);
        return administratorDao.queryUnfinishedItemList(rowBounds, State.DURING_AUCTION);
    }

    @Override
    public Administrator selectAdminByQtalk(String qtalk) {
        return administratorDao.selectAdminByQtalk(qtalk);
    }

    @Override

    public void addAdministrator(Administrator administrator) {
        administratorDao.addAdministrator(administrator);
    }

    @Override
    public void addCategory(Category category) {
        administratorDao.addCategory(category);
    }

    @Override
    public List<Category> queryAllCategories(Integer currentPage, Integer pageSize) {
        // currentPage从前端传来的时候从1开始, 所以在这减一
        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);
        return administratorDao.queryAllCategories(rowBounds);
    }

}
