package com.wang.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface DictDao {

    @Insert("insert into sys_dict(name) values(#{name})")
    int insertDict(@Param("name") String name);

    @Select("select id,name from sys_dict")
    List<Map> list();

    @Select("select id,name from sys_dict limit 2,2")
    List<Map> listLimit();

}
