package com.ylzInfo.service;

import com.ylzInfo.bean.FjAccessToken;
import com.ylzInfo.util.Result;

public interface DemoService {
    Result saveToken(FjAccessToken fjAccessToken);

    Result delectToken(String tokenId);

    Result queryToken(String tokenId);
}
