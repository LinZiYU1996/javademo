package SE.innerClass;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 面试
 *
 *
 * @Date 16:32 2019/4/18
 **/
public class TestOffer2 {

    //输出结果
    public static void main(String[] args)  {
        Outter outter = new Outter();
        outter.new Inner().print();
    }

    //成员内部类的继承问题。一般来说，内部类是很少用来作为继承用的。但是当用来继承的话，要注意两点：
    //
    //　　1）成员内部类的引用方式必须为 Outter.Inner.
    //
    //　　2）构造器中必须有指向外部类对象的引用，并通过这个引用调用super()

}
class Outter
{
    private int a = 1;
    class Inner {
        private int a = 2;
        public void print() {
            int a = 3;
            System.out.println("局部变量：" + a);
            System.out.println("内部类变量：" + this.a);
            System.out.println("外部类变量：" + Outter.this.a);
        }
    }
}