package com.cye.mybatis.mybatistest;

import com.cye.mybatis.mybatistest.dao.ProductMapper;
import com.cye.mybatis.mybatistest.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.Configuration;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.UUID;

@SpringBootApplication
@MapperScan("com.cye.mybatis.mybatistest.dao")
@Slf4j
public class MybatistestApplication implements ApplicationRunner {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(MybatistestApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Product product = Product.builder().id(UUID.randomUUID().toString()).name("萝卜").money(20D).build();
        Long id = productMapper.save(product);
        log.info("product {} => {}", id, product);
        Product p = productMapper.findById("339c3c51-ede0-4b84-81ce-2e3e64d40f8c");
        log.info("product {}", p);
    }
}
