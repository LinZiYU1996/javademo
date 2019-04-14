package SE.polymorphic;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 考察Java多态
 *
 * 策略：考虑优先级顺序
 *优先级从高到低：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
 *
 *
 *
 * @Date 15:46 2019/4/14
 **/
public class Test {



    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        //a1是A类的一个实例化对象，所以this指向A，
        // 然后查找this.show(b),由于没有这个方法，
        // 所以到super.show（b），但是由于A类没有超类了，
        // 所以到this.show(super b),由于b的超类是A，
        // 所以相当于this.show(A),然后在A类中查找到了这个方法，
        // 于是输出A and A。
        System.out.println(a1.show(b));


        //同样，a1是A类的实例化对象，所以this指向A，
        // 然后在A类中查找this.show（C）方法，由于没有这个方法，
        // 所以到了super.show(C),但是A没有超类，
        // 所以到了this.show(super C)，
        // 由于C的超类是B所以在A类里面查找this.show(B)方法，
        // 也没找到，然后B也有超类，就是A，所以查找this.show(A),找到了，
        // 于是输出A and A；
        System.out.println(a1.show(c));


        //a1是A类的实例化对象，所以this指向A，
        // 然后在A类中找到this.show(D)方法，找到了，所以就输出A and D
        System.out.println(a1.show(d));


        //a2是B类的引用对象，类型为A，所以this指向A类，
        // 然后在A类里面找this.show(B)方法，没有找到，
        // 所以到了super.show(B),由于A类没有超类，
        // 所以到了this.show（super B），B的超类是A，即super B = A，
        // 所以执行方法this。show（A），在A方法里面找show（A），找到了，
        // 但是由于a2是一个类B的引用对象，而B类里面覆盖了A类的show（A）方法，
        // 所以最终执行的是B类里面的show（A）方法，即输出B and A；
        System.out.println(a2.show(b));

        //a2是B类的引用对象，类型为A，所以this指向A类，
        // 然后在A类里面找this.show(C)方法，没有找到，
        // 所以到了super.show（C）方法，由于A类没有超类，
        // 所以到了this.show(super C),C的超类是B，
        // 所以在A类里面找show（B），同样没有找到，
        // 发现B还有超类，即A，所以还继续在A类里面找show（A）方法，
        // 找到了，但是由于a2是一个类B的引用对象，而B类里面覆盖了A类的show（A）方法，
        // 所以最终执行的是B类里面的show（A）方法，即输出B and A；
        System.out.println(a2.show(c));

        //a2是B类的引用对象，类型为A，所以this指向A类，
        // 然后在A类里面找this.show(D)方法，找到了，
        // 但是由于a2是一个类B的引用对象，
        // 所以在B类里面查找有没有覆盖show（D）方法，没有，
        // 所以执行的是A类里面的show（D）方法，即输出A and D；
        System.out.println(a2.show(d));

        //b是B类的一个实例化对象，首相执行this.show(B)，
        // 在B类里面找show（B）方法，找到了，直接输出B and B；


        //b是B类的一个实例化对象，首先执行this.show(C)，
        // 在B类里面找show（C）方法，没有找到，
        // 所以到了super.show(c),B的超类是A，
        // 所以在A类中找show（C）方法，没有找到，
        // 于是到了this.show(super C),C的超类是B，
        // 所以在B类中找show(B)f方法，找到了，
        // 所以执行B类中的show（B）方法输出B and B；
        System.out.println(b.show(c));

        //b是B类的一个实例化对象，
        // 首相执行this.show(D)，在B类里面找show（D）方法，没有找到，
        // 于是到了super.show(D),B的超类是A类，所以在A类里面找show（D）方法
        // 找到了，输出A and D；
        System.out.println(b.show(d));

    }


}

class A {
    public String show(D obj){
        return ("A and D");
    }

    public String show(A obj){
        return ("A and A");
    }
}

class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    }
}

class C extends B{

}

class D extends  B{

}
