package com.xupt.bookshop.service.Contact;

import com.xupt.bookshop.model.common.Contact;

import java.util.List;

/**
 * Created by zhangge on 16-5-23.
 */
public interface ContactService {
    public void createContact(Contact contact);
    public List<Contact> queryContacts();
}
