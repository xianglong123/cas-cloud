package com.cas.controller;

import com.cas.service.CommonService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午6:11 2021/1/13
 * @version: V1.0
 * @review:
 */
@RestController
public class CommonController {

    @Resource
    private CommonService commonService;

    @RequestMapping("/ok/hys")
    public String ok() {
        return commonService.ok();
    }


    @RequestMapping("/timeout/hys")
    public String timeout() {
        return commonService.timeout();
    }

    @RequestMapping("/breaker/{id}")
    public String breaker(@PathVariable("id") Integer id) {
        return commonService.breaker(id);
    }

}
