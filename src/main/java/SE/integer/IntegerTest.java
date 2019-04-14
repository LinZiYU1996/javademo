package SE.integer;



/*
*
 * @Author Mr.Lin
 * @Description //
 * Integer的equal比较的是具体int的值
 *
 *
 * @Date 10:44 2019/4/14
 **/
public class IntegerTest {

    public static void main(String[] args) {
        int src = 65536;
        Integer obj = new Integer(65536);
        System.out.println(src == obj);     //输出true
        System.out.println(obj.equals(src));    //输出true
    }


}
