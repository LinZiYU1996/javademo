package SE;

/*
*
 * @Author Mr.Lin
 * @Description //测试 euual 和 ==
 *
 * String中的equal方法被重写过，因为object的equal方法是比较对象的内存地址，而String的equal是比较对象的值
 *
 * 当创建String类型的对象是，虚拟机会在常量池中查找有没有已经存在的值和创建的值相同的对象，如果有就把它赋给当前引用，
 * 如果没有就在常量池重新创建一个String对象
 *
 *
 * @Date 15:40 2019/4/13
 **/
public class EqualTest {


    public static void main(String[] args) {

        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = "aaa";
        String s4 = "aaa";
        if (s3 == s4){
            System.out.println("s3 == s4");
        }
        if (s1 == s2){
            System.out.println("s1 == s2");
        }
        if (s1.equals(s2)){
            System.out.println("s1EQUALs2");
        }


    }


}
