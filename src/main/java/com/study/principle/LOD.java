package com.study.principle;

/**
 * @version ：V1.0
 * @description: 迪米特原则 Law of Demeter
 * @author: zhj
 * @create: 2020-04-16 13:44
 */
public class LOD {

    /**
     *  迪米特原则:
     *
     *  迪米特原则又叫最少知道原则，就是说一个类对于其他类尽可能的少依赖。
     *  如果必须依赖，是通过一个中间类来建立关联。迪米特原则的初衷就是为了降低耦合。
     *
     *  缺点：会创建大量的中间类以及方法（这些方法仅仅是为了间接调用才出现的方法，与业务逻辑无关系。）
     */
}