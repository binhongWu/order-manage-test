package com.wbh.manage.controller;
import com.wbh.manage.common.utils.JSONResult;
import com.wbh.manage.entity.Brand;
import com.wbh.manage.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author wbh
 * @since 2018-08-09
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    private final Logger logger = LoggerFactory.getLogger(BrandController.class);
    @Autowired
    public BrandService brandService;

    /**
    * 通过id获取Brand
    * @param id
    * @return
    */
    @GetMapping("/{id}")
    public JSONResult<Brand> getBrandById(@PathVariable String id){
        JSONResult<Brand> jsonResult = new JSONResult<>();
        try {
        Brand result = brandService.selectById(id);
        jsonResult.setData(result);
        jsonResult.setStatusCode(String.valueOf(HttpStatus.OK));
        jsonResult.setSuccess(true);
        } catch (Exception e) {
        jsonResult.setSuccess(false);
        jsonResult.setStatusCode(String.valueOf(HttpStatus.EXPECTATION_FAILED));
        jsonResult.setMessage("异常信息:" + e.getClass().getName());
        logger.info("异常信息:{}", e.getMessage());
        }
        return jsonResult;
    }


}

