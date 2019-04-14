package SE.polymorphic;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 * @Date 16:51 2019/4/14
 **/
public class Test5 {

    public static void main(String[] args) {
        char[] c1 = new char[2];
        char[] c2 = new char[2];

        c1[0] = 'a';
        c1[1] = 'b';

        c2[0] = 'a';
        c2[1] = 'b';

        System.out.println(c1.equals(c2)); //输出false

        String s1 = new String(c1);
        String s2 = new String(c2);

        System.out.println(s1.equals(s2));  //输出true


    }


}
