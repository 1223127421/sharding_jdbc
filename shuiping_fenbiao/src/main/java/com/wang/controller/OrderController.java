package com.wang.controller;

import com.wang.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 水平分表
 * 主键id采用雪花算法自动生成
 */
@RestController
@RequestMapping("/fenbiao")
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @RequestMapping("/insert")
    public String insertOrder() {
        //添加6条数据，查看每张表是否各添加3条数据，且根据order_id分表
        for (int i = 0; i < 6; i++) {
            orderDao.insertOrder(new BigDecimal(i), 1l, "success");
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
