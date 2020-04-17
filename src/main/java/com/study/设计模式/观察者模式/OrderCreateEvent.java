package com.study.设计模式.观察者模式;

import org.springframework.context.ApplicationEvent;

/**
 * @version ：V1.0
 * @description: 创建新订单事件
 * @author: zhj
 * @create: 2020-04-17 15:17
 */
public class OrderCreateEvent extends ApplicationEvent {


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param order the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public OrderCreateEvent(OrderModel order) {
        super(order);
    }
}