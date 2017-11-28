package com.scbrl.controller.remote.ipml;

import com.scbrl.controller.base.BaseController;
import com.scbrl.entity.SysUser;
import com.scbrl.feign.remote.UserFeignClient;
import com.scbrl.service.SysUserService;
import com.scbrl.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模块:【类模块名称】
 * <p>
 * 开发: Bruce.Liu By 2017/11/25 下午4:15 Create
 */
@RestController
@RequestMapping(value="/user")
public class UserFeignClientImpl extends BaseController implements UserFeignClient  {


    @Autowired
    private SysUserService sysUserService;

    @Override
    @RequestMapping(value="/{username}/rvo")
    public ResultVO findByUsernameRvo(@PathVariable("username") String username) {
        if(!RestfulSign()){
            System.err.println("非法请求，签名验证无效！");
            // return null;
        } else {
            System.err.println("签名验证通过！");
        }
        //System.err.println(getRequest().getContextPath()+":"+getRequest().getLocalPort());
        SysUser sysUser = sysUserService.findByUsername(username);
        ResultVO rvo = new ResultVO();
        rvo.setCode("Succeed");
        rvo.setMsg("成功");
        rvo.setData(sysUser);
        return rvo;
    }
}
