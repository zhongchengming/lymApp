package com.ylzInfo.controller;

import com.ylzInfo.service.MessageService;
import com.ylzInfo.util.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("message")
@Controller
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("getMessageList")
    @ResponseBody
    public Result getMessageList(HttpServletRequest request) {
        return messageService.getMessageList(request);
    }
}
