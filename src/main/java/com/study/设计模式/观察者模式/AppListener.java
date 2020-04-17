package com.study.设计模式.观察者模式;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @version ：V1.0
 * @program: eBey-demo
 * @description: app推送监听器
 * @author: zhj
 * @create: 2020-04-17 16:13
 */
@Component  //给自定义的事件进行排序
public class AppListener implements SmartApplicationListener {

    //支持的事件类型
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == OrderCreateEvent.class;
    }

    //事件发生的目标类
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == OrderModel.class;
    }

    //执行顺序   数值越小证明优先级越高，执行顺序越靠前。
    @Override
    public int getOrder() {
        return 0;
    }


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 获取注册用户信息
        OrderCreateEvent orderCreateEvent = (OrderCreateEvent) event;

        System.out.println(String.format("给%s发送APP通知", orderCreateEvent.getSource()));
    }
}