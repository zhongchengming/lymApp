//package com.ylzInfo.controller;
//
//import com.ylzInfo.bean.FjAccessToken;
//import com.ylzInfo.service.DemoService;
//import com.ylzInfo.util.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//@RequestMapping("test")
//public class DemoController {
//    @Autowired
//    DemoService demoService;
//
//    /**
//     * 新增
//     * @param request
//     * @return
//     */
//    @RequestMapping("add")
//    @ResponseBody
//    public Result addVersionfj1233(HttpServletRequest request) {
//        try {
//            FjAccessToken fjAccessToken = new FjAccessToken();
//            fjAccessToken.setId("1");
//            Result result = demoService.saveToken(fjAccessToken);
//            return result;
//        }catch (Exception e){
//            return new Result(0,"服务器异常");
//        }
//
//
//    }
//    /**
//     * 删除
//     */
//    @RequestMapping("delectToken")
//    @ResponseBody
//    public Result delectToken(HttpServletRequest request) {
//        FjAccessToken fjAccessToken = new FjAccessToken();
//      String tokenId = fjAccessToken.getId();
//        Result result = demoService.delectToken(tokenId);
//        return result;
//
//    }
//    /**
//     * 查询token
//     */
//    @RequestMapping("queryToken")
//    @ResponseBody
//    public Result queryToken(HttpServletRequest request) {
//        FjAccessToken fjAccessToken = new FjAccessToken();
//        String tokenId = fjAccessToken.getId();
//        Result result = demoService.queryToken(tokenId);
//        return result;
//
//    }
//}
