package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.login.User;
import com.xupt.bookshop.model.login.param.RegisterParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangge on 16-4-25.
 */
@Repository
public interface LoginDao {
    /**
     * 按照姓名查找用户，用于在每一个处理前进行用户是否存在检验
     *
     * @param name
     * @return
     */
    public User queryByName(@Param("name")String name);

    /**
     * 创建用户
     * @param registerParam
     */
    public void addUser(@Param("user")RegisterParam registerParam);
}
