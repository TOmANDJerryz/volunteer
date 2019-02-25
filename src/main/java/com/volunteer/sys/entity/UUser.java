package com.volunteer.sys.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UUser implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;
    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 邮箱|登录帐号
     */
    @TableField("email")
    private String email;

    /**
     * 密码
     */
    @TableField("pswd")
    private String pswd;

    @TableField("age")
    private Integer age;

    @TableField("sex")
    private String sex;

    @TableField("wechat")
    private String wechat;

    @TableField("phone")
    private String phone;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    /**
     * 1:有效，0:禁止登录
     */
    @TableField("status")
    private Long status;


}
