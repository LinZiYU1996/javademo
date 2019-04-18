package SE.innerClass;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 局部内部类
 * @Date 15:50 2019/4/18
 **/
public class TestStaticInnerClass2 {

    private static int a;

    private int b;

    public void test(final int c){
        final int d = 1;


        //局部内部类就像是方法里面的一个局部变量一样，
        // 是不能有public、protected、private以及static修饰符的。
        class  Inner{
            public void print(){
                System.out.println(c);
            }
        }



    }


    public static void main(String[] args) {

    }


}
