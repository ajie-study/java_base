package com.study.设计模式.模板方法模式;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SaleServiceTest {

    @Resource
    private SaleService saleService;

    @Test
    public void getSaleByType() {
        double normal = saleService.getSaleByType("vip", 100);

        System.out.println(normal);
    }
}