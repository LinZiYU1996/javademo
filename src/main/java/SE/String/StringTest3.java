package SE.String;




/*
*
 * @Author Mr.Lin
 * @Description
 * //java中常量优化机制，编译时s1已经成为“abc”在常量池中查找创建，s2不需要再创建。
 * @Date 10:37 2019/4/14
 **/
public class StringTest3 {

    public static void main(String[] args) {
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2);  //输出true
        System.out.println(s1.equals(s2)); //输出true
    }


}
