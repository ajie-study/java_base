package com.study.设计模式.模板方法模式;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @version ：V1.0
 * @program: my-project
 * @description: 商品售价service
 * @author: zhj
 * @create: 2020-04-26 15:50
 */
@Service
public class SaleService {


    //所有实现类的聚合
    private static HashMap<String, CalculateStrategy> calculateStrategyMap = new HashMap<>();


    /**
     *  spring中的特性 --- 默认会将所有的实现类，存入到list中
     * @param calculateStrategies 实现类列表
     */
    public SaleService(List<CalculateStrategy> calculateStrategies){

        calculateStrategies.forEach( item ->{
            calculateStrategyMap.put(item.getType(),item);
        });
    }

    public double getSaleByType(String type, double money){

        //获取用户类型
        CalculateStrategy calculateStrategy = calculateStrategyMap.get(type);

        Double sale = calculateStrategy.getSale(money);

        return  sale;

    }
}