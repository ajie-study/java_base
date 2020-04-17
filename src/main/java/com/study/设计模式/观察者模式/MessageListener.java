package com.study.设计模式.观察者模式;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @version ：V1.0
 * @description: 短信监听器
 * @author: zhj
 * @create: 2020-04-17 16:03
 */
@Component
public class MessageListener {

    @EventListener()
    public void listener(OrderCreateEvent event) {

        System.out.println(String.format("给%s发送短信通知", event.getSource()));
    }

}