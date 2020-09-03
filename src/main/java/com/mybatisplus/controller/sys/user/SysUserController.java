package com.mybatisplus.controller.sys.user;


import com.mybatisplus.service.sys.user.ISysUserService;
import com.mybatisplus.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
