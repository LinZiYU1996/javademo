package SE.String;


/*
*
 * @Author Mr.Lin
 * @Description //

常量折叠，是一种编译器优化技术。
* 对于 String s1 = "1" + "2"; 编译器会给你优化成 String s1 = "12";
*  在生成的字节码中，根本看不到 "1" "2" 这两个东西。常量折叠有什么条件？
* 必须是编译期常量之间进行运算才会进行常量折叠。编译期常量就是“编译的时候就可以确定其值的常量”，
* 而且这个认定比较严格。首先：字面量是编译期常量。（数字字面量，字符串字面量等）其次：
* 编译期常量进行简单运算的结果也是编译期常量，如1+2，"a"+"b"。最后：
* 被编译器常量赋值的 final 的基本类型和字符串变量也是编译期常量。
* 对于（一）s1 和 s2 都是字符串字面量相加，都是编译期常量，
* 都会被编译器进行常量折叠。对于（二）s3 是字符串字面量相加
* ，但是 s4 却是两个非 final 的变量相加，所以不会进行常量折叠。
* 而是根据 String 类特有的 + 运算符重载，变成类似这样的代码
*  String s4 = new StringBuffer(a).append(b).toString();
* 这里toString()会生成新的String变量，显然用 == 运算符比较是会返回 false。
* （一）其实只创建了一个 "abc" 字符串对象，且位于字符串常量池中。
* （二）如果你将 String a, String bc 前面都加上 final 修饰的话，结果会有不同。
 *
 * @Date 11:24 2019/4/14
 **/
public class StringTest7 {


    public static void main(String[] args) {
        String s1 = "a" + "bc";
        String s2 = "ab" + "c";
        System.out.println(s1 == s2);  //输出true

        String a = "a";
        String bc = "bc";
        String s3 = "a" + "bc";
        String s4 = a + bc;
        System.out.println(s3 == s4);   //输出false

        final  String d = "d";
        final  String de = "de";
        String s5 = "d" + "de";
        String s6 = d + de;

        System.out.println(s5 == s6);  //输出true

    }

}
