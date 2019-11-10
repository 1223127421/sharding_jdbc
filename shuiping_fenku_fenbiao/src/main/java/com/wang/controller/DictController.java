package com.wang.controller;

import com.wang.dao.DictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共表，即每个库都存在的表，数据结构和数据相同
 */
@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    DictDao dictDao;

    @RequestMapping("/insert")
    public String insertDict() {
        //添加2条数据，每个库中都会插入相同的数据
        for (int i = 0; i < 2; i++) {
            dictDao.insertDict("字典" + i);
        }
        return "insertDict success";
    }

    @RequestMapping("/list")
    public String list() {
        return dictDao.list().toString();
    }


    @RequestMapping("/listLimit")
    public String listLimit() {
        return dictDao.listLimit().toString();
    }

}
