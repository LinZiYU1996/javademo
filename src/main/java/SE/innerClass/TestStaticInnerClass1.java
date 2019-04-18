package SE.innerClass;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 成员内部类
 * @Date 15:47 2019/4/18
 **/
public class TestStaticInnerClass1 {

    private  Inner inner = null;

    private static int a = 100;

    private int b = 200;


    //成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
    //不过要注意的是，当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，
    // 即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，
    // 需要以下面的形式进行访问：
    //外部类.this.成员变量
    //外部类.this.成员方法

    //虽然成员内部类可以无条件地访问外部类的成员，
    // 而外部类想访问成员内部类的成员却不是这么随心所欲了。
    // 在外部类中如果要访问成员内部类的成员，
    // 必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问：

    //成员内部类是依附外部类而存在的，
    // 也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象

    public class Inner{
        public void print(){
            System.out.println(a);//访问外部的private static 成员
            System.out.println(b); //访问外部的private 成员


        }
    }

    public Inner getInnerClass(){
        if ( inner == null) {
            inner = new Inner();
        }
        return inner;
    }

    public static void main(String[] args) {

        //创建的第一种方式
        TestStaticInnerClass1 outerClass = new TestStaticInnerClass1();
        TestStaticInnerClass1.Inner inner = outerClass.new Inner();//通过外部类来实现
        inner.print();

        System.out.println("----------------------------------");
        //创建的第二种方式
        TestStaticInnerClass1.Inner inner1 = outerClass.getInnerClass();
        inner1.print();

        //　内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。
        // 比如上面的例子，如果成员内部类Inner用private修饰，则只能在外部类的内部访问，
        // 如果用public修饰，则任何地方都能访问；如果用protected修饰，
        // 则只能在同一个包下或者继承外部类的情况下访问；如果是默认访问权限，
        // 则只能在同一个包下访问。这一点和外部类有一点不一样，
        // 外部类只能被public和包访问两种权限修饰。我个人是这么理解的，
        // 由于成员内部类看起来像是外部类的一个成员，所以可以像类的成员一样拥有多种权限修饰。

    }


}
