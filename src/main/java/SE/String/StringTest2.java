package SE.String;


/*
*
 * @Author Mr.Lin
 * @Description //字符串常量池
 * @Date 22:02 2019/4/13
 **/
public class StringTest2 {


    public static void main(String[] args) {
        String s1 = new String("a"); //同时在堆和常量池创建了"a"
        String s2 = new String("a"); //在堆中创建了"a"
        String s3 = "a"; //直接引用常量池的"a"了
        String s4 = "a"; //直接引用常量池的"a"了

        String s5 = "a"; // 直接引用常量池的"a"了
        String s6 = new String("a");  //在堆中创建了"a"
        s6.intern();


        System.out.println(s1 == s2);  //输出false  对象地址不同
        System.out.println(s1 == s3); //输出false  对象地址不同
        System.out.println(s3 == s4); //输出true  //都是直接用的常量池中的"a"的地址

        System.out.println(s5 == s6); //输出false  //对象地址不同



        System.out.println("s1地址   " + System.identityHashCode(s1));
        System.out.println("s2地址  " + System.identityHashCode(s2));
        System.out.println("s3地址  " + System.identityHashCode(s3));
        System.out.println("s4地址  " + System.identityHashCode(s4));
        System.out.println("s5地址  " + System.identityHashCode(s5));
        System.out.println("s6地址  " + System.identityHashCode(s6));


        s6 = s6.intern(); //把常量池中字符串"a"的地址赋给s6
        System.out.println(s5 == s6); //输出true

        System.out.println("s6地址  " + System.identityHashCode(s6));
    }

}
