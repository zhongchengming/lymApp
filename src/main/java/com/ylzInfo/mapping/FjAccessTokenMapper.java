package com.ylzInfo.mapping;


import com.ylzInfo.bean.FjAccessToken;
import org.springframework.web.bind.annotation.Mapping;

/**
 * Created by zhongchengming on 2018/7/6.
 */
public interface FjAccessTokenMapper {

    FjAccessToken selectByToken(String token);

    void saveToken(FjAccessToken tokenStr);

    void delectByToken(String userToken);

    void updataToken(FjAccessToken fjAccessToken);
}
