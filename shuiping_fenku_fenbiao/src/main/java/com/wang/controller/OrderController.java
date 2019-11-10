package com.wang.controller;

import com.wang.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 水平分库分表
 * 通过user_id实现水平分库
 * 通过order_id实现水平分表
 * 主键order_id采用雪花算法自动生成
 */
@RestController
@RequestMapping("/fenku")
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @RequestMapping("/insert")
    public String insertOrder() {
        // 添加8条数据，查看每个库的每张表的数据是否是根据user_id分库且order_id分表
        for (int i = 0; i < 8; i++) {
            orderDao.insertOrder(new BigDecimal(i), Long.valueOf(i), "success");
        }
        return "insertOrder success";
    }

    @RequestMapping("/list")
    public String list() {
        return orderDao.list().toString();
    }


    @RequestMapping("/listLimit")
    public String listLimit() {
        return orderDao.listLimit().toString();
    }

}
