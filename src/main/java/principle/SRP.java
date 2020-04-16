package principle;

/**
 * @version ：V1.0
 * @description: 单一职责原则 Single Responsibility Principle (SRP)
 * @author: zhj
 * @create: 2020-04-16 11:10
 */
public class SRP {

    /**
     * 单一职责原则:
     *
     * 如果一个类承担的职责过多，就等于把这些职责耦合在一起了。
     * 一个职责的变化可能会削弱或者抑制这个类完成其他职责的能力。
     * 这种耦合会导致脆弱的设计，当发生变化时，设计会遭受到意想不到的破坏。
     * 而如果想要避免这种现象的发生，就要尽可能的遵守单一职责原则。此原则的核心就是解耦和增强内聚性。
     *
     * 白话：就是一个人只做一件事，如果一个人负责很多事情，可能再处理某件事的时候会影响到其他事情的处理
     */

    public static void main(String[] args) {

        //假设当前是orderService（订单模块）

        System.out.println("创建订单----");   //订单模块  -- 自身的模块

        System.out.println("调用短信模块的API ---> 发送短信通知---");  //短信模块  --- 需调用短信模块的API

        System.out.println("调用APP推送模块的API ---> 发送APP推送通知---");  //APP推送模块  --- 需调用APP推送模块的API

        // 保证一个模块只干自身模块的事情，其他的模块操作交给其他模块
    }
}