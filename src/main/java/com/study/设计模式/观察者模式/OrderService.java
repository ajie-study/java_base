package com.study.设计模式.观察者模式;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version ：V1.0
 * @description: 订单service
 * @author: zhj
 * @create: 2020-04-17 15:07
 */
@Service
public class OrderService {

    @Resource
    ConfigurableApplicationContext  applicationContext;

    /**
     * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
     * 比如，当一个对象被修改时，则会自动通知它的依赖对象。观察者模式属于行为型模式。
     *
     * 此处我们使用spring的事件监听  ---- 并符合java设计原则中的单一职责和开闭原则
     */

    public void createOrder(OrderModel orderModel){


        //创建订单的必须操作
        System.out.println("订单模块--->  创建订单");

        //实例order创建事件
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent(orderModel);

        //触发事件
        applicationContext.publishEvent(orderCreateEvent);
    }
}