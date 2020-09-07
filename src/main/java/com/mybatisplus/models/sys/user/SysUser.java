package com.mybatisplus.models.sys.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author czw
 * @since 2020-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 删除标识（1-男，2-女）
     */
    private Integer userSex;

    /**
     * 创建人ID
     */
    private Long addUser;

    /**
     * 创建时间
     */
    private String addTime;

    /**
     * 修改人ID
     */
    private Long modUser;

    /**
     * 修改时间
     */
    private String modTime;

    /**
     * 排序字段
     */
    private String orderTag;

    /**
     * 删除标识（1-正常，2-删除）
     */
    private Integer delFlag;

    /**
     * 备注信息
     */
    private String remarks;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
