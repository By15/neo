package com.neo.gateway.client;

import com.insight.utils.pojo.Reply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author By15
 * @date 2021/11/24 13:38
 */
@FeignClient(name = "auth_center")
public interface AuthClient {

    /**
     * 获取用户授权码
     *
     * @param info 用户关键信息
     * @return Reply
     */
    @GetMapping("/base/auth/v1.0/tokens/permits")
    Reply getPermits(@RequestHeader("loginInfo") String info);
}
