package com.wang.controller;

import com.wang.dao.OrderDao;
import com.wang.utils.GuuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 读写分离
 * 主键id采用雪花算法自动生成
 */
@RestController
@RequestMapping("/read_write")
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @RequestMapping("/insert")
    public String insertOrder() {
        //查看数据源是否是master
        for (int i = 0; i < 3; i++) {
            orderDao.insertOrder(GuuidUtil.getUUID(), new BigDecimal(i), 1l, "success");
        }
        return "insertOrder success";
    }

    @RequestMapping("/list")
    public String list() {
        //查看数据源是否是slave
        return orderDao.list().toString();
    }

}
