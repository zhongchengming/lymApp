//package com.ylzInfo.service.serviceImpl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.ylzInfo.bean.FjAccessToken;
//import com.ylzInfo.mapping.FjAccessTokenMapper;
//import com.ylzInfo.service.HomeService;
//import com.ylzInfo.util.Result;
//import com.ylzInfo.util.support.domain.EsbRequest;
//import com.ylzInfo.util.support.domain.Row;
//import com.ylzInfo.util.support.service.EsbServiceFactory;
//import com.ylzInfo.util.support.service.QueryListService;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class HomeServiceImpl implements HomeService {
//    @Autowired
//    private EsbServiceFactory esbServiceFactory;
//    @Autowired
//    private FjAccessTokenMapper fjAccessTokenMapper;
//
//
//    public EsbServiceFactory getEsbServiceFactory() {
//        return esbServiceFactory;
//    }
//
//    public void setEsbServiceFactory(EsbServiceFactory esbServiceFactory) {
//        this.esbServiceFactory = esbServiceFactory;
//    }
//    public Result versionInfofj(String cpage, String type,String pageSize) {
//        List<Row> queryList = null;
//        String[] keys = new String[]{"cpage", "rows", "type", "versionname","key","termid"};
//        String[] values = new String[]{cpage, pageSize, type, null,this.getKeyFromesb(),"192.160.23"};
//        QueryListService es;
//        EsbRequest esbRequest = EsbRequest.getRequest("fjapp.ylz.ps.cm.app.version.selectversion", keys, values);
//        return this.esbRequert(esbRequest,true,true);
//   }
//
//    public Result addVersionfj1233(String i_version, String i_type, String i_url, String i_versionname, String i_isforceupdate, String i_description) {
//        String[] keys = new String[]{"i_version", "i_type", "i_url", "i_versionname","key","termid","i_isforceupdate","i_description"};
//        String[] values = new String[]{i_version, i_type, i_url, i_versionname,this.getKeyFromesb(),"192.160.23",i_isforceupdate,i_description};
//        EsbRequest esbRequest = EsbRequest.getRequest("fjapp.ylz.ps.cm.app.version.insertversion", keys, values);
//        return this.esbRequert(esbRequest,false,false);
//    }
//
//    public Result delectVersionfj1233(String i_version) {
//        String[] keys = new String[]{"i_version","key","termid"};
//        String[] values = new String[]{i_version,this.getKeyFromesb(),"192.160.23"};
//        EsbRequest esbRequest = EsbRequest.getRequest("fjapp.ylz.ps.cm.app.version.deleteversion", keys, values);
//        return this.esbRequert(esbRequest,false,false);
//    }
//
//    public Result init(Map<String, String> params) {
//      FjAccessToken fjAccessToken =  fjAccessTokenMapper.selectByToken("abc35213-96c6-4fba-a089-91d540b0b08e");
//      return new Result(Result.SUCCESS,"成功",fjAccessToken);
//    }
//
//    public Result updataVersionfj1233(String i_version, String i_type, String i_url, String i_versionname, String i_isforceupdate, String i_description) {
//        String[] keys = new String[]{"i_version", "i_type", "i_url", "i_versionname","key","termid","i_isforceupdate","i_description"};
//        String[] values = new String[]{i_version, i_type, i_url, i_versionname,this.getKeyFromesb(),"192.160.23",i_isforceupdate,i_description};
//        EsbRequest esbRequest = EsbRequest.getRequest("fjapp.ylz.ps.cm.app.version.updateversion", keys, values);
//        return this.esbRequert(esbRequest,false,false);
//    }
//
//    public String getKeyFromesb() {
//        String[] keys = new String[]{"esbuser","termid","rows","cpage"};
//        String[] values = new String[]{"fjweb","12122222","1","1"};
//        JSONObject json = new JSONObject();
//        List<Row> queryList = null;
//        QueryListService es;
//        EsbRequest esbRequest = EsbRequest.getRequest("com.ylz.ps.cm.getpublicKey", keys, values);
//        try {
//            es = getEsbServiceFactory().getServiceWithRequest(esbRequest, QueryListService.class);
//            if (es.getFaultCode() != null || es.getQueryList() == null || es.getQueryList().size() <= 0) {
//                return null;
//            } else {
//                queryList = es.getQueryList();
//                Iterator iter = queryList.get(0).entrySet().iterator();
//                while (iter.hasNext()) {
//                    Map.Entry entry = (Map.Entry) iter.next();
//                    json.put(entry.getKey().toString().toLowerCase(), entry.getValue());
//                }
//                return json.getString("key");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public Result esbRequert(  EsbRequest esbRequest,boolean list, boolean  pagination){
//        List<Row> queryList = null;
//        QueryListService es;
//        try {
//            es = getEsbServiceFactory().getServiceWithRequest(esbRequest, QueryListService.class);
//            if (es.getFaultCode() != null || es.getQueryList() == null || es.getQueryList().size() <= 0) {
//                return new Result(Result.FAIL, es.getInformation());
//            } else {
//                ArrayList arrayList = new ArrayList();
//                queryList = es.getQueryList();
//                if(queryList.size()>1||list==true) {
//                    for (int i = 0; i < queryList.size(); i++) {
//                        JSONObject json = new JSONObject();
//                        Iterator iter = queryList.get(i).entrySet().iterator();
//                        while (iter.hasNext()) {
//                            Map.Entry entry = (Map.Entry) iter.next();
//                            json.put(entry.getKey().toString().toLowerCase(), entry.getValue());
//                        }
//                        arrayList.add(json);
//                    }
//                    if(pagination==true){
//                        JSONObject jsonObject = new JSONObject();
//                        jsonObject.put("totalPages",es.getTotalPages());
//                        jsonObject.put("totalCounts",es.getTotalCounts());
//                        jsonObject.put("list",arrayList);
//                        return new Result(Result.SUCCESS, "请求成功", jsonObject);
//                    }else {
//                        return new Result(Result.SUCCESS, "请求成功", arrayList);
//                    }
//                }else {
//                    JSONObject json = new JSONObject();
//                    Iterator iter = queryList.get(0).entrySet().iterator();
//                    while (iter.hasNext()) {
//                        Map.Entry entry = (Map.Entry) iter.next();
//                        json.put(entry.getKey().toString().toLowerCase(), entry.getValue());
//                    }
//                    if(StringUtils.equalsIgnoreCase((String) json.get("status"),"0")){
//                        return new Result(Result.FAIL, (String) json.get("msg"), null);
//                    }
//                    return new Result(Result.SUCCESS, "请求成功", json);
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result(Result.FAIL, e.getMessage());
//        }
//    }
//
//}
