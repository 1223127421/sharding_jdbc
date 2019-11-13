package com.wang.controller;

import com.wang.dao.OrderDao;
import com.wang.utils.GuuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 读写分离+水平分库+水平分表
 * 主键id采用雪花算法自动生成
 */
@RestController
@RequestMapping("/read_write_fenku_fenbiao")
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @RequestMapping("/insert")
    public String insertOrder() {
        for (int i = 0; i < 10; i++) {
            orderDao.insertOrder(GuuidUtil.getUUID(), new BigDecimal(i), 1l, "success");
            orderDao.insertOrder(GuuidUtil.getUUID(), new BigDecimal(i), 2l, "success");
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
