package principle;

import java.util.ArrayList;
import java.util.List;

/**
 * @version ：V1.0
 * @description: 开放封闭原则 Open-Closed Principle (OCP)
 * @author: zhj
 * @create: 2020-04-16 11:19
 */
public class OCP {

    /**
     *  开放封闭原则:
     *
     *  开放封闭原则是所有面向对象原则的核心
     *  个软件实体如类、模块和函数应该对扩展开放，对修改关闭。
     *  软件设计本身所追求的目标就是封装变化、降低耦合，而开放封闭原则正是对这一目标的最直接体现
     *
     *   优点：可维护、可扩展、可复用、灵活性高
     */

    /**
     * 书籍接口
     */
    interface IBook {

        String getName();  //书名

        Double getPrice(); //价格

        String getAuthor(); // 作者
    }


    static class BookService implements IBook {


        private String name;
        private Double price;
        private String author;

        public BookService(String name, Double price, String author) {
            this.name = name;
            this.price = price;
            this.author = author;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Double getPrice() {
            return price;
        }

        @Override
        public String getAuthor() {
            return author;
        }
    }

    //需求：所有书的价格打八折----遵循开闭原则


    //打折书籍
    static class DiscountBookService extends BookService {


        public DiscountBookService(String name, Double price, String author) {
            super(name, price, author);
        }

        @Override
        public Double getPrice() {
            //价格打八折
            return super.getPrice() * 0.8;
        }
    }


    public static void main(String[] args) {

        //初始化数据
        List<IBook> books = new ArrayList<>();

        books.add(new DiscountBookService("巴黎圣母院", 50.00, "雨果"));
        books.add(new DiscountBookService("悲惨世界", 60.00, "雨果"));


        System.out.println("购买书籍的数据如下");

        books.forEach(item -> {
            System.out.println(String.format("%s--%s--%s", item.getName(), item.getPrice(), item.getAuthor()));
        });

    }

}