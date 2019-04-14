package SE.String;


/*
*
 * @Author Mr.Lin
 * @Description //
 *理解 String pool 机制。
 * 如果 Spring pool 在执行语句之前没有 “Cat” 对象，
 * 那么会创建 2 个 String；
 * 反之只创建 1 个 String 对象，”Cat” 会从 String pool 中直接返回对象。
 * @Date 10:56 2019/4/14
 **/
public class StringTest5 {

    public static void main(String[] args) {
        String string = new String("aaa"); // 这句代码会创建几个 String 对象？

    }


}
