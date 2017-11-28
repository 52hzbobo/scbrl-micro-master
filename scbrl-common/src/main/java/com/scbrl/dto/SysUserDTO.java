package com.scbrl.dto;

import lombok.Data;

import java.util.Date;

/**
 * 模块:【用户信息主表】
 * <p>
 * 开发: Bruce.Liu By 2017/11/5 下午2:26 Create
 */
@Data
public class SysUserDTO {

    /**
     * 主键
     */
    private String userId;

    /**
     * 登录账号(手机号)
     */
    private String username ;

    /**
     * 密码
     */
    private String password ;

    /**
     * 昵称
     */
    private String nickName ;

    /**
     * 角色Id
     */
    private String roleId ;

    /**
     * 用户状态
     */
    private String userState ;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createWho;


    /**
     * 定义空构造函数
     */
    public SysUserDTO() {}

    /**
     * 定义有参构造函数
     */
    public SysUserDTO(SysUserDTO u ){
        userId = u.getUserId();
        username = u.getUsername();
        password = u.getPassword();
        nickName = u.getNickName();
        roleId = u.getRoleId();
        userState = u.getUserState();
        createTime = u.getCreateTime();
        createWho = u.getCreateWho();
    }
}
