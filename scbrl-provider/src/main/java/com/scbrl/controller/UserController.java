package com.scbrl.controller;

import com.scbrl.controller.base.BaseController;
import com.scbrl.entity.SysUser;
import com.scbrl.service.SysUserService;
import com.scbrl.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 模块:【用户RestfulAPI】
 * <p>
 * 开发: Bruce.Liu By 2017/11/19 下午2:01 Create
 */
@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value= "/toTest")
    public String toTest(){
        return "toTest";
    }

    @GetMapping(value= "/{username}")
    public SysUser findByUsername(
            @PathVariable String username
    ){
        if(!RestfulSign()){
            System.err.println("非法请求，签名验证无效！");
           // return null;
        } else {
            System.err.println("签名验证通过！");
        }
        return sysUserService.findByUsername(username);
    }

}
