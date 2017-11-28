package com.scbrl.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 模块:【公共返回对象】
 * <p>
 * 开发: Bruce.Liu By 2017/11/20 下午10:12 Create
 */
@Data
public class ResultVO implements Serializable {

    private String code ;

    private String msg ;

    private Object data ;

}
