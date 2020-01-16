package com.cye.mybatis.mybatistest;

import com.cye.mybatis.mybatistest.dao.ProductMapper;
import com.cye.mybatis.mybatistest.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
@MapperScan("com.cye.mybatis.mybatistest.dao")
@Slf4j
class MybatistestApplicationTests {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private DataSource dataSource;
    @Test
    void contextLoads() {
    }
    @Test
    void test() {
        Product product = Product.builder().id(UUID.randomUUID().toString()).name("萝卜").money(20D).build();
        Long id = productMapper.save(product);
        log.info("product {} => {}", id, product);
        Product p = productMapper.findById("339c3c51-ede0-4b84-81ce-2e3e64d40f8c");
        log.info("product {}", p);
    }

}
