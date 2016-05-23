package com.xupt.bookshop.web.controller;

import com.xupt.bookshop.model.common.Contact;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.service.Contact.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by zhangge on 16-5-23.
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Resource
    ContactService contactService;
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public Object create(@Valid Contact contact){
        contactService.createContact(contact);
        return JsonResult.succ("提交成功");
    }
}
