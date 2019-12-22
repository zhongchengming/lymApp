//package com.ylzInfo.controller;
//import com.ylzInfo.service.HomeService;
//import com.ylzInfo.util.HttpRequst;
//import com.ylzInfo.util.Result;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//public class HomeController {
//    @Autowired
//    private HomeService homeService;
//    /**
//     * 登录
//     * @param request
//     * @param model
//     * @return
//     */
//    @RequestMapping("login")
//    public String login(HttpServletRequest request,Model model) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        if(StringUtils.equalsIgnoreCase((String) request.getSession().getAttribute("username"),"admin")){
//            return "viewManage/viewHome";
//        }
//        if(StringUtils.equalsIgnoreCase(username,"admin")&&StringUtils.equalsIgnoreCase(password,"abcd123e45")){
//            request.getSession().setAttribute("password",password);
//            request.getSession().setAttribute("username",username);
//            model.addAttribute("message", "登录成功");
//            return "viewManage/viewHome";
//        }else {
//            model.addAttribute("message", "登录失败");
//            return "index";
//        }
//    }
//
//    /**
//     * 福建1233app版本管理界面
//     * @param request
//     * @param model
//     * @return
//     */
//    @RequestMapping("appVersionManager")
//    public String appVersionManager(HttpServletRequest request,Model model) {
//        return "viewManage/appVersionManage";
//    }
//
//    /**
//     * 请求福建1233app版本信息
//     */
//    @RequestMapping("versionInfofj")
//    @ResponseBody
//    public Result versionInfofj(HttpServletRequest request) {
//        String cpage =  request.getParameter("pageNumber");
//        String pageSize = request.getParameter("pageSize");
//        String type =   request.getParameter("i_type");
//        Result result = homeService.versionInfofj(cpage,type,pageSize);
//        return result;
//    }
//
//    /**
//     * 增加版本记录
//     * @param request
//     * @return
//     */
//    @RequestMapping("addVersionfj1233")
//    @ResponseBody
//    public Result addVersionfj1233(HttpServletRequest request) {
//        String i_version = request.getParameter("i_version");
//        String i_type = request.getParameter("i_type");
//        String i_url  = request.getParameter("i_url");
//        String i_versionname = request.getParameter("i_versionname");
//        String i_isforceupdate = request.getParameter("i_isforceupdate");
//        String i_description = request.getParameter("i_description");
//        Result result = homeService.addVersionfj1233(i_version,i_type,i_url,i_versionname,i_isforceupdate,i_description);
//        return result;
//
//    }
//    /**
//     * 删除版本记录
//     * @param request
//     * @return
//     */
//    @RequestMapping("delectVersionfj1233")
//    @ResponseBody
//    public Result delectVersionfj1233(HttpServletRequest request) {
//        String i_version = request.getParameter("i_version");
//
//        Result result = homeService.delectVersionfj1233(i_version);
//        if(result.getResultMsg()==null){
//            return new Result(Result.SUCCESS,"删除成功","");
//        }
//        return result;
//
//    }
//    /**
//     * 修改版本记录
//     * @param request
//     * @return
//     */
//    @RequestMapping("updataVersionfj1233")
//    @ResponseBody
//    public Result updataVersionfj1233(HttpServletRequest request) {
//
//        String i_version = request.getParameter("i_version");
//        String i_type = request.getParameter("i_type");
//        String i_url  = request.getParameter("i_url");
//        String i_versionname = request.getParameter("i_versionname");
//        String i_isforceupdate = request.getParameter("i_isforceupdate");
//        String i_description = request.getParameter("i_description");
//        Result result = homeService.updataVersionfj1233(i_version,i_type,i_url,i_versionname,i_isforceupdate,i_description);
//        return result;
//    }
//    /**
//     * jndiTest
//     */
//    @RequestMapping("init")
//    @ResponseBody
//    public Result init( HttpServletRequest request) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("accessToken","3564f664-8557-4165-9e09-4d1c3476c7a6");
//        params.put("type","IOS");
//        return homeService.init(params);
//    }
//
//}
