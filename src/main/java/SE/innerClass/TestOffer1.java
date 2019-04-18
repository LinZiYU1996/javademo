package SE.innerClass;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 面试
 *如何初始化 bean1 bean2 bean3
 * @Date 16:26 2019/4/18
 **/
public class TestOffer1 {

    public static void main(String[] args){
        // 初始化Bean1
        TestOffer1 outerClass = new TestOffer1();
        TestOffer1.Bean1 bean1 = outerClass.new Bean1();
        bean1.I++;
        System.out.println(bean1.I);
        System.out.println("-----------------------");


        // 初始化Bean2
        TestOffer1.Bean2 bean2 = new TestOffer1.Bean2();
        bean2.J++;
        System.out.println(bean2.J);
        System.out.println("-----------------------");


        //初始化Bean3
       Bean bean = new Bean();
       Bean.Bean3 bean3 = bean.new Bean3();
        bean3.k++;
        System.out.println(bean3.k);
        System.out.println("-----------------------");
    }


    //　从前面可知，对于成员内部类，必须先产生外部类的实例化对象，才能产生内部类的实例化对象。
    // 而静态内部类不用产生外部类的实例化对象即可产生内部类的实例化对象。
    //
    //　　创建静态内部类对象的一般形式为：  外部类类名.内部类类名 xxx = new 外部类类名.内部类类名()
    //
    //　　创建成员内部类对象的一般形式为：  外部类类名.内部类类名 xxx = 外部类对象名.new 内部类类名()

    class Bean1{
        public int I = 0;
    }

    static class Bean2{
        public int J = 0;
    }
}

class Bean{
    class Bean3{
        public int k = 0;
    }


}
