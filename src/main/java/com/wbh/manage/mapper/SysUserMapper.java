package com.wbh.manage.mapper;

import com.wbh.manage.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wbh
 * @since 2018-08-09
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByUserId(@Param("userId") String userId);
}
