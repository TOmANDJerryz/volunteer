package com.volunteer.sys.entity;

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
public class URole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 角色名称
     */
    @TableField("name")
    private String name;

    /**
     * 角色类型
     */
    @TableField("type")
    private String type;


}
