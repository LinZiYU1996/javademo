package SE.integer;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 * 使用==的情况：
如果比较Integer变量，默认比较的是地址值。
Java的Integer维护了从-128~127的缓存池
如果比较的某一边有操作表达式(例如a+b)，那么比较的是具体数值


*
* 使用equals()的情况：
无论是Integer还是Long中的equals()默认比较的是数值。
Long的equals()方法，JDK的默认实现：会判断是否是Long类型


*
 * @Date 11:29 2019/4/15
 **/
public class IntegerTest1 {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c == d); //输出true  数值在线程池范围  相同
        System.out.println(e == f);  //输出false   数值超出线程池范围  不同
        System.out.println(c == (a + b));  //输出true  因为有 a+b 表达式  因此比较的是数值
        System.out.println(c.equals(a + b));  //输出true  因为equal比较的是数值
        System.out.println(g == (a + b));  //输出true    同样表达式原因

        // Long的equals()先判断传递进来的是不是Long类型，而a+b自动装箱的是Integer类型
        System.out.println(g.equals(a + b)); //输出false


        //装箱成Long
        System.out.println(g.equals(a + h));  //输出true

    }

}
