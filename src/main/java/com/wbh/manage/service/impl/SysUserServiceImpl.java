package com.wbh.manage.service.impl;

import com.wbh.manage.entity.SysUser;
import com.wbh.manage.mapper.SysUserMapper;
import com.wbh.manage.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wbh
 * @since 2018-08-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser selectByUserId(String userId) {
        return sysUserMapper.selectByUserId(userId);
    }
}
