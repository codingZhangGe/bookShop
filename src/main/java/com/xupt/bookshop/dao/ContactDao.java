package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.common.Contact;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangge on 16-5-23.
 */
@Repository
public interface ContactDao {
    public  void insertContact(@Param("contact")Contact contact);
    public List<Contact> selectContact();
}
