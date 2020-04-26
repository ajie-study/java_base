package com.study.设计模式.模板方法模式;

import org.springframework.stereotype.Service;

/**
 * @version ：V1.0
 * @program: my-project
 * @description: 普通会员
 * @author: zhj
 * @create: 2020-04-26 15:58
 */
@Service
public class NormalStrategy implements CalculateStrategy{

    @Override
    public String getType() {
        return "normal";
    }

    @Override
    public Double getSale(Double money) {
        return money * 0.9;
    }


}