package com.study.test;

/**
 * @version ：V1.0
 * @program: my-project
 * @description:
 * @author: zhj
 * @create: 2020-04-23 15:23
 */




public class Demo1 {

    public static void main(String[] args) {
        Demo1 d = new Demo1();
        String str = d.getName("jack");
        System.out.println(str);
    }

    protected String getName(String userID){
        //循环枚举类，其实是循环定义在枚举类中的枚举
        for(flow t:flow.values()){
            if(userID!=null&&userID.trim().equals(t.getTag())){
                String str = t.handle(userID);
                return str;
            }
        }
        return "没有改配置方法";

    }

    //定义枚举类
    enum flow{
        //给枚举自定义方法
        JACK("jack"){

            @Override
            public String handle(String userID) {

                return "jack";
            }
        },
        MIKE("make"){


            public String handle(String userID) {

                return "mike";
            }

        },
        LILI("lili"){

            @Override
            public String handle(String userID) {

                return "lili";
            }

        };
        //枚举属性
        private final String tag;

        flow(String tag){
            this.tag = tag;
        }
        public String getTag(){
            return tag;
        }

        public abstract String handle(String userID);
    }
}