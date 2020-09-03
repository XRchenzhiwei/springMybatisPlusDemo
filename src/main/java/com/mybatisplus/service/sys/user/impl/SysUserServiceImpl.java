package com.mybatisplus.service.sys.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.models.sys.user.SysUser;
import com.mybatisplus.mapper.sys.user.SysUserMapper;
import com.mybatisplus.service.sys.user.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author czw
 * @since 2020-08-28
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private SysUserMapper sysUserMapper;

    @Autowired
    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public Page getPageList(Integer pageSize, Integer pageNum, String userName) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!StringUtils.isEmpty(userName), "user_name", userName);
        return sysUserMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
    }
}
