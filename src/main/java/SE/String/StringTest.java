package SE.String;


/*
*
 * @Author Mr.Lin
 * @Description //字符串的题目
 * @Date 21:52 2019/4/13
 **/
public class StringTest {


    public static void main(String[] args) {
        String aa = "aa";
        String bb = "aa"+"bb";
        String aabb = aa + "bb";
        System.out.println(bb == aabb);//输出false
    }


}
