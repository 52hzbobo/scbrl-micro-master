package com.scbrl.feign.remote;

import com.scbrl.vo.ResultVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模块:【用户模块Feigh调用】
 * <p>
 * 开发: Bruce.Liu By 2017/11/24 下午6:07 Create
 */
@FeignClient(path = "user" ,value = "provider-service")
public interface UserFeignClient {

    @RequestMapping(value="/{username}/rvo")
    public ResultVO findByUsernameRvo(@PathVariable("username") String username);

}
