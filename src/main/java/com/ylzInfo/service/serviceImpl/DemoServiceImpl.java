//package com.ylzInfo.service.serviceImpl;
//
//import com.ylzInfo.bean.FjAccessToken;
//import com.ylzInfo.mapping.FjAccessTokenMapper;
//import com.ylzInfo.service.DemoService;
//import com.ylzInfo.util.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DemoServiceImpl implements DemoService {
//  @Autowired
//    FjAccessTokenMapper fjAccessTokenMapper;
//
//    public Result saveToken(FjAccessToken fjAccessToken) {
//        fjAccessTokenMapper.saveToken(fjAccessToken);
//        return new Result(1,"保存成功");
//    }
//
//    public Result delectToken(String tokenId) {
//        fjAccessTokenMapper.delectByToken(tokenId);
//        return new Result(1,"删除成功");
//    }
//
//    public Result queryToken(String tokenId) {
//      FjAccessToken fjAccessToken =  fjAccessTokenMapper.selectByToken(tokenId);
//      Result result = new Result(1);
//      result.setResultBody(fjAccessToken);
//      result.setResultMsg("查询成功！");
//      return result;
//    }
//}
