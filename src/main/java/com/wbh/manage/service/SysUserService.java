package com.wbh.manage.service;

import com.wbh.manage.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wbh
 * @since 2018-08-09
 */
public interface SysUserService extends IService<SysUser> {

    SysUser selectByUserId(String userId);
}
