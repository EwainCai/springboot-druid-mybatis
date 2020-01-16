package com.cye.mybatis.mybatistest.dao;

import com.cye.mybatis.mybatistest.pojo.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductMapper {

    @Insert("insert into product (id, name, money) values (#{id}, #{name}, #{money})")
    @Options(useGeneratedKeys = true)
    Long save(Product product);

    @Select("select * from product where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "money", property = "money")
    })
    Product findById(@Param("id") String id);
}
