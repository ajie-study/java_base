package com.study.设计模式.模板方法模式;

/**
 * @version ：V1.0
 * @program: my-project
 * @description: 计算售价的策略
 * @author: zhj
 * @create: 2020-04-26 15:55
 */
public interface CalculateStrategy {

    /**
     * 账号类型
     * @return
     */
    String getType();


    /**
     * 获取售价
     * @return
     */
    Double getSale(Double money);

}