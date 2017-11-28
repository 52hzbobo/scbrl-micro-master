package com.scbrl.controller;

import com.scbrl.controller.base.BaseController;
import com.scbrl.entity.SysRole;
import com.scbrl.service.SysRoleMenuService;
import com.scbrl.service.SysRoleService;
import com.scbrl.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 模块:【角色RestfulAPI】
 *
 * 时间: Bruce.Liu By 2017/11/19 下午2:27 Create
 */

@RestController
@RequestMapping(value="/role")
public class RoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    @GetMapping(value = "/{roleId}")
    public SysRole findByRoleId(
            @PathVariable String roleId
    ){
        return sysRoleService.findByRoleId(roleId);
    }

    @GetMapping(value = "/{roleId}/menu")
    public List<LinkedHashMap>  findMenuByRoleId(
            @PathVariable String roleId ,
            HttpServletRequest req
    ){
        System.err.println("服务地址以及端口号>>>  "+req.getLocalAddr()+":"+req.getLocalPort());
        return sysRoleMenuService.selectByRoleMenuList(roleId);
    }

}
