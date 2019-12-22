package com.ylzInfo.service;

import com.ylzInfo.util.Result;

import javax.servlet.http.HttpServletRequest;

public interface MessageService {
    Result getMessageList(HttpServletRequest request);
}
