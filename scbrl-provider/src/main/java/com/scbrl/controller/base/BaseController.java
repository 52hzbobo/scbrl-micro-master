package com.scbrl.controller.base;

import com.scbrl.util.MD5Util;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 模块:【基础Controller】
 * <p>
 * 开发: Bruce.Liu By 2017/11/20 下午10:40 Create
 */
public class BaseController {

    /**
     * 得到request对象
     * @return
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public boolean RestfulSign(){
        HttpServletRequest req = getRequest();
        if(req.getHeader("sign") !=null && req.getHeader("timestamp") !=null &&
                req.getHeader("sign").equals(MD5Util.RestfulSign(req.getHeader("timestamp"),req.getLocalAddr()))){
            return true;
        }
        return false ;
    }


}
