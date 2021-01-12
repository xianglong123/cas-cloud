package com.cas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午6:47 2021/1/12
 * @version: V1.0
 * @review:
 */
@RestController
public class CommonController {

    @RequestMapping("/getName")
    public String getName() {
        return "xianglong";
    }

}
