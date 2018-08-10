package com.wbh.manage.controller;


import com.wbh.manage.common.utils.JSONResult;
import com.wbh.manage.entity.SysUser;
import com.wbh.manage.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wbh
 * @since 2018-08-09
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    private final Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    public SysUserService sysUserService;

    /**
    * 通过userId获取SysUser
    * @param
    * @return
    */
    @GetMapping("/{userId}")
    public JSONResult<SysUser> getSysUserById(@PathVariable String userId){
        SysUser s = new SysUser();
        System.out.println(s.selectById("1"));
        JSONResult<SysUser> jsonResult = new JSONResult<>();
        try {
        SysUser result = sysUserService.selectByUserId(userId);
        jsonResult.setData(result);
        jsonResult.setStatusCode(String.valueOf(HttpStatus.OK));
        jsonResult.setSuccess(true);
        } catch (Exception e) {
        jsonResult.setSuccess(false);
        jsonResult.setStatusCode(String.valueOf(HttpStatus.OK));
        jsonResult.setMessage("异常信息:" + e.getClass().getName());
        logger.info("异常信息:{}", e.getMessage());
        e.printStackTrace();
        }
        return jsonResult;
    }


}

