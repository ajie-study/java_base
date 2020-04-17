package com.study.test;

import com.study.设计模式.观察者模式.OrderModel;
import com.study.设计模式.观察者模式.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void createOrder() {

        OrderModel orderModel = new OrderModel();
        orderModel.setId(1);
        orderModel.setUsername("ajie");

        orderService.createOrder(orderModel);
    }
}