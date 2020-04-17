package com.study.comparator;

import com.study.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 使用lambda进行排序
 *
 * @author ajie
 * @date 2019-10-11 15:01
 */

public class lambdaComparator {

    private static List<User> list = new ArrayList<>();


    public static void main(String[] args) {

        list.add(new User("张三", "上海", 18));
        list.add(new User("李四", "北京", 20));
        list.add(new User("王五", "杭州", 19));

        System.out.println("排序前：" + list.toString());

        //对list集合的数据进行按照年龄排序
        //传统写法();

        //lambda写法
        Collections.sort(list, (o1,o2)->Integer.compare(o1.getAge(), o2.getAge()));
        System.out.println("排序后："+list.toString());

    }

    private static void 传统写法() {
        Collections.sort(list, new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {

                //升序
                //return Integer.compare(o1.getAge(), o2.getAge());

                //降序
                return Integer.compare(o2.getAge(), o1.getAge());
            }
        });
        System.out.println("排序后：" + list.toString());
    }
}
