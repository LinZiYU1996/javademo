package SE.String;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *s3会在堆创建新的对象“abc”

 *但是intern会返回常量池中的“abc”地址给s3
 *
 * 因此s1 和 s3相同地址
 * @Date 10:59 2019/4/14
 **/
public class StringTest6 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a";
        String s3 = (s2 + "bc").intern();
        System.out.println(s1 == s3);  //输出true

    }


}
