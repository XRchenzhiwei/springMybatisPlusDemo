package com.mybatisplus.service.sys.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.models.sys.user.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author czw
 * @since 2020-08-28
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 分页列表
     *
     * @param pageSize
     * @param pageNum
     * @param userName
     * @return
     */
    Page getPageList(Integer pageSize, Integer pageNum, String userName);

    /**
     * 新增
     *
     * @param sysUser
     */
    void add(SysUser sysUser);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 编辑
     * @param sysUser
     */
    void edit(SysUser sysUser);
}
