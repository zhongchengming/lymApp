package com.ylzInfo.service;

import com.ylzInfo.util.Result;

import java.util.Map;

public interface HomeService {
    Result versionInfofj(String cpage,String type,String pageSize);

    Result addVersionfj1233(String i_version, String i_type, String i_url, String i_versionname, String i_isforceupdate, String i_description);

    Result delectVersionfj1233(String i_version);

    Result init(Map<String, String> params);

    Result updataVersionfj1233(String iVersion, String i_type, String i_url, String i_versionname, String i_isforceupdate, String i_version);
}
