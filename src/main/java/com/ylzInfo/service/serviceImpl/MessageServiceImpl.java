package com.ylzInfo.service.serviceImpl;

import com.ylzInfo.bean.Message;
import com.ylzInfo.mapping.MessageMapping;
import com.ylzInfo.service.MessageService;
import com.ylzInfo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapping messageMapping;

    public Result getMessageList(HttpServletRequest request) {
         List<Message>list = messageMapping.getMessageList();
        return new Result(1,"请求成功",list);
    }
}
