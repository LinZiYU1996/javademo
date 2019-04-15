package JDK8;


import java.util.Arrays;
import java.util.List;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * Java8 通过lambda启动线程
 *
 * 使用lambda表达式对列表进行迭代
 *
 *
 *
 * @Date 19:32 2019/4/15
 **/
public class StartThread {

    public static void main(String[] args) {
//        new
//                Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start(); //启动线程



        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

        //jdk8之前对列表进行迭代
        for (Object feature : features) {

            System.out.println(feature);

        }

        System.out.println("--------------------");

        features.forEach(n -> System.out.println(n));  //使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，



    }

}
