package com.scbrl.dto;

import lombok.Data;

import java.util.Date;

/**
 * 模块:【角色信息表】
 * <p>
 * 开发: Bruce.Liu By 2017/11/5 下午2:46 Create
 */
@Data

public class SysRoleDTO {

    /**
     * 主键
     */
    private String roleId;

    /**
     * 角色编码
     */
    private String roleCode ;

    /**
     * 角色名称
     */
    private String roleName ;

    /**
     * 角色状态
     */
    private String roleState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createWho;


}
