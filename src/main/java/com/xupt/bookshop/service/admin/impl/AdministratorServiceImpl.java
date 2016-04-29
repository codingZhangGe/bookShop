package com.xupt.bookshop.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xupt.bookshop.dao.AdministratorDao;
import com.xupt.bookshop.service.admin.AdministratorService;
import com.xupt.bookshop.model.admin.Administrator;
import com.xupt.bookshop.model.admin.FinishedItemInfoForQuery;
import com.xupt.bookshop.model.admin.UnfinishedItemForQuery;
import com.xupt.bookshop.model.common.Category;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

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
      //  return administratorDao.queryUnfinishedItemList(rowBounds, State.UN_START_AUCTION);
        return null;
    }

    @Override
    public List<UnfinishedItemForQuery> queryDuringAuctionItemList(Integer currentPage, Integer pageSize) {
        // currentPage从前端传来的时候从1开始, 所以在这减一
        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);
        //return administratorDao.queryUnfinishedItemList(rowBounds, State.DURING_AUCTION);
        return  null;
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
