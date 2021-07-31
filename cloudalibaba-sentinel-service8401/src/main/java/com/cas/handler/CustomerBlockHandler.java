package com.cas.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2021/7/31 12:40 下午
 * @desc
 */
public class CustomerBlockHandler {

    public static String handlerException(BlockException e) {
        return "安客户自定义处理 handlerException ----- 1";
    }

    public static String handlerException2(BlockException e) {
        return "安客户自定义处理 handlerException ----- 2";
    }

}
