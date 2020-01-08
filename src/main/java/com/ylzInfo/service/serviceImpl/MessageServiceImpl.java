package com.ylzInfo.service.serviceImpl;

import com.ylzInfo.bean.Message;
import com.ylzInfo.mapping.MessageMapping;
import com.ylzInfo.service.MessageService;
import com.ylzInfo.util.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapping messageMapping;

    public Result getMessageList(HttpServletRequest request) {
        System.out.println("getMessageList 执行了");
        List<Message> list = messageMapping.getMessageList();
        return new Result(1, "请求成功", list);
    }
}
