package principle;

/**
 * @version ：V1.0
 * @description: 依赖倒置原则 Dependency Inversion Principle
 * @author: zhj
 * @create: 2020-04-16 13:16
 */
public class DIP {

    /**
     *  依赖倒置原则:   (面向接口编程)
     *
     *  定义：高层模块不应该依赖低层模块，二者都应该依赖其抽象；抽象不应该依赖细节；细节应该依赖抽象。
     *
     *  低层模块：在程序设计中，一些类实现了最基本、基础的操作。我们称呼为低层模块。
     *
     *  高层次模块：一些类实现了复杂的逻辑封装，并且依赖低层次模块。
     */

    // 高层模块   --- 自动驾驶
    class AutoDrive{

        private ICar car;

        public AutoDrive(ICar car){
            this.car = car;
        }


        public void carRun(){   //低层模块的修改不影响AutoDrive模块
            car.run();
        }

    }

    // 所有车类型的基本操作
    interface ICar{

        void run();   //启动

        void turn();  //转弯

        void stop();  //停止
    }

    // 低层模块
    class 福特 implements ICar{

        @Override
        public void run() {
            System.out.println("福特汽车启动---");
        }

        @Override
        public void turn() {
            System.out.println("福特汽车转弯---");
        }

        @Override
        public void stop() {
            System.out.println("福特汽车停止---");
        }
    }


    // 低层模块
    class 本田 implements ICar{

        @Override
        public void run() {
            System.out.println("本田汽车启动---");
        }

        @Override
        public void turn() {
            System.out.println("本田汽车转弯---");
        }

        @Override
        public void stop() {
            System.out.println("本田汽车停止---");
        }
    }
}