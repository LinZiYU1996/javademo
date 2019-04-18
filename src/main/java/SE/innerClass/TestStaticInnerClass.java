package SE.innerClass;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 静态内部类
 *
 * @Date 11:43 2019/4/18
 **/
public class TestStaticInnerClass {

    private static int a = 100;

    private int b;

    public static class Inner{
        public void print(){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
            TestStaticInnerClass.Inner inner = new TestStaticInnerClass.Inner();
            inner.print();
    }

}
