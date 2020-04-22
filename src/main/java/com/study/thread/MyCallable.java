package com.study.thread;

import java.util.concurrent.Callable;

/**
 * @version ：V1.0
 * @program: my-project
 * @description:
 * @author: zhj
 * @create: 2020-04-20 10:33
 */
public class MyCallable implements Callable {
    private String name;

    public MyCallable(String s) {
        this.name = s;

    }

    @Override
    public Object call() throws Exception {
        return name;
    }
}