package JDK8;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *用来支持Java的函数式编程。其中一个便是Predicate
 * ，使用 java.util.function.Predicate 函数式接口以及lambda表达式，
 * 可以向API方法添加逻辑，用更少的代码支持更多的动态行为
 *
 *
 * 我们只定义了一个conditionFilter方法，stream()会将当前list作为源创建一个Stream对象
 * ，collect(Collectors.toList())是将最终的结果封装在ArrayList中（
 * 这部分会在后续stream学习中详细介绍，这里只关注filter即可），
 * filter方法接收一个Predicate类型参数用于对目标集合进行过滤。
 * 里面并没有任何具体的逻辑，提供了一种更高层次的抽象化，
 * 我们可以把要处理的数据和具体的逻辑通过参数传递给conditionFilter即可。
 * 理解了这种设计思想后，再看上面的例子就很容易理解，本身逻辑并不复杂
 * ，分别取出小于5、大于等于5、小于8的元素，最后一个总是返回true的条件意味着打印出集合中所有元素。
除此之外，Predicate还提供了另外三个默认方法和一个静态方法
 * @Date 19:46 2019/4/15
 **/
public class Jdk8_Predicate {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Jdk8_Predicate predicateTest = new Jdk8_Predicate();
        //输出大于5的数字
        List<Integer> result = predicateTest.conditionFilter(list, integer -> integer > 5);
        result.forEach(System.out::println);
        System.out.println("-------");
        //输出大于等于5的数字
        result = predicateTest.conditionFilter(list, integer -> integer >= 5);
        result.forEach(System.out::println);
        System.out.println("-------");
        //输出小于8的数字
        result = predicateTest.conditionFilter(list, integer -> integer < 8);
        result.forEach(System.out::println);
        System.out.println("-------");
        //输出所有数字
        result = predicateTest.conditionFilter(list, integer -> true);
        result.forEach(System.out::println);
        System.out.println("-------");

    }

    public List<Integer> conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());

    }
}