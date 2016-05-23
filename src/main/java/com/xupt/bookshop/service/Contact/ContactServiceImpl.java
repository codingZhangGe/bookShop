package com.xupt.bookshop.service.Contact;

import com.xupt.bookshop.dao.ContactDao;
import com.xupt.bookshop.model.common.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangge on 16-5-23.
 */
@Service("ContactService")
public class ContactServiceImpl implements ContactService{
    Logger logger= LoggerFactory.getLogger(ContactServiceImpl.class);
    @Resource
    ContactDao contactDao;
    @Override
    public void createContact(Contact contact) {
       logger.info("<ContactServiceImpl>  createContact");
        contactDao.insertContact(contact);
    }

    @Override
    public List<Contact> queryContacts() {
        return contactDao.selectContact();
    }
}
