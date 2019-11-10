package com.wang.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface OrderDao {

    @Insert("insert into t_order_(price,user_id,status) values(#{price},#{userId},#{status})")
    int insertOrder(@Param("price") BigDecimal price, @Param("userId") Long userId, @Param("status") String status);


    @Select("select order_id,price from t_order_")
    List<Map> list();

}
