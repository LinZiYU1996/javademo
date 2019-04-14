package SE.polymorphic;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * Java 多态考察
 *
 * java中静态属性和和静态方法可以被继承，但是没有被重写（overwrite）而是被隐藏。

静态方法和属性是属于类的，调用的时候直接通过类名.方法名完成的，
* 不需继承机制就可以调用如果子类里面定义了静态方法和属性，那么这时候父类的静态方法 或属性称之为“隐藏”，
* 你如果想要调用父类的静态方法和属性，直接通过父类名.方法名或变量名完成，至于是否继承一说，
* 子类是有继承静态方法和属性，但是 跟实例方法和属性不太一样，存在“隐藏”的这种情况。

多态之所以能够实现是依赖于 继承 接口和 重写 、重载（继承和重写最为关键）。
* 有了继承和重写就可以 实现父类的引用可以指向不同子类的对象。重写的功能是：
* “重写”后子类的优先级要高于父类的优先级，但是“隐藏”是没有这个优先级之分的。

静态属性、静态方法和非静态的属性都可以被 继承 和 隐藏 而不能够被重写，
* 因此不能实现多态，不能实现父类的引用可以指向不同子类的对象。
非静态的方法可以被继承和重写，因此可以实现多态。

 *
 * @Date 16:09 2019/4/14
 **/
public class Test2 {

    public static void main(String[] args) {

            //输出的结果都是父类中的非静态属性、静态属性和静态方法,推出静态属性和静态方法可以被继承
            J  j = new J();
            System.out.println(j.name);
            System.out.println(j.str);
            j.sing();
            System.out.println("----------------------------");

            //结果同上，输出的结果都是父类中的非静态属性、静态属性和静态方法,推出静态属性和静态方法可以被继承
            G j1 = new J();
            System.out.println(j1.name);
            System.out.println(j1.str);
            j1.sing();
            System.out.println("----------------------------");

            //结果都是子类的非静态属性，静态属性和静态方法，这里和非静态属性和非静态类的继承相同
            //子类的改写后非静态方法
            H h = new H();
            System.out.println(h.name);
            System.out.println(h.str);
            h.sing();
            h.run();
            System.out.println("----------------------------");


            //结果是父类的静态属性，说明静态属性不可以被重写，不能实现多态
            //结果是父类的非静态属性，说明非静态属性不可以被重写，不能实现多态
            //结果都是父类的静态方法，说明静态方法不可以被重写，不能实现多态
            //结果是子类的改写后的非静态方法
            G h1 = new H();
            System.out.println(h1.str);
            System.out.println(h1.name);
            h1.sing();
            h1.run();
            System.out.println("----------------------------");

    }



}

class G{
    public static String str = "静态属性";

    public String name = "非静态属性";

    public static void sing(){
        System.out.println("静态方法");
    }

    public void run(){
        System.out.println("非静态方法");
    }

}


class H extends G{
    public static String str = "H改写后的静态属性";

    public String name = "H改写后的非静态属性";

    public static void sing(){
        System.out.println("H改写后的静态方法");
    }

    public void run(){
        System.out.println("H改写后的非静态方法");
    }


}


class J extends G{

}















