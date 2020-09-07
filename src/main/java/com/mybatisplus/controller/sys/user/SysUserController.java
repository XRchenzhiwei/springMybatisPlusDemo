package com.mybatisplus.controller.sys.user;


import com.mybatisplus.models.sys.user.SysUser;
import com.mybatisplus.service.sys.user.ISysUserService;
import com.mybatisplus.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author czw
 * @since 2020-08-28
 */
@RestController
@RequestMapping("/demo/sysUser")
public class SysUserController {

    @Resource
    ISysUserService iSysUserService;

    @GetMapping("pageList")
    public Result getPageList(
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "userName", required = false) String userName) {
        return Result.success(iSysUserService.getPageList(pageSize, pageNum, userName));
    }

    @PostMapping("add")
    public Result add(SysUser sysUser) {
        if (null == sysUser) {
            return Result.error("参数为空");
        }
        iSysUserService.add(sysUser);
        return Result.success();
    }

    @DeleteMapping("delete")
    public Result delete(
            @RequestParam(value = "id") Long id
    ) {
        if (null == id) {
            return Result.error("参数不可为空");
        }
        iSysUserService.delete(id);
        return Result.success();
    }

    @PatchMapping("edit")
    public Result edit(SysUser sysUser) {
        if (null == sysUser) {
            return Result.error("参数为空");
        }
        iSysUserService.edit(sysUser);
        return Result.success();
    }

}
