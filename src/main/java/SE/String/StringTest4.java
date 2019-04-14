package SE.String;



/*
*
 * @Author Mr.Lin
 * @Description
 * Java 语言提供对字符串串联符号（”+”）
 * 和其他对象到字符串的转换的特殊支持。
 * 字符串串联是通过 StringBuilder（或 StringBuffer）类及其 append 方法实现的，
 * 字符串转换是通过 toString 方法实现的。
 * 在本例子中，
 * 先在常量池中创建”ab“，地址指向s1,再创建”abc”，指向s2。对于s3，
 * 先创建StringBuilder（或 StringBuffer）对象，通过append连接得到“abc”,
 * 再调用toString()转换得到的地址指向s3。故(s3==s2)为false.

 * @Date 10:40 2019/4/14
 **/
public class StringTest4 {

    public static void main(String[] args) {
        String s1="ab";
        String s2="abc";
        String s3=s1+"c";
        System.out.println(s3==s2);     //输出false
        System.out.println(s3.equals(s2));      //输出true
    }


}
