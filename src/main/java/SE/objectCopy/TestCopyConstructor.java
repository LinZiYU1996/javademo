package SE.objectCopy;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 * 通过拷贝构造方法实现浅拷贝：

拷贝构造方法指的是该类的构造方法参数为该类的对象。
* 使用拷贝构造方法可以很好地完成浅拷贝，直接通过一个现有的对象创建出与该对象属性相同的新的对象。
 * @Date 19:52 2019/4/18
 **/
public class TestCopyConstructor {


    //这里对Person类选择了两个具有代表性的属性值：一个是引用传递类型；另一个是字符串类型（属于常量）。
    //
    //通过拷贝构造方法进行了浅拷贝，各属性值成功复制。其中，p1值传递部分的属性值发生变化时，
    // p2不会随之改变；而引用传递部分属性值发生变化时，p2也随之改变。
    //
    //要注意：如果在拷贝构造方法中，对引用数据类型变量逐一开辟新的内存空间，创建新的对象，
    // 也可以实现深拷贝。而对于一般的拷贝构造，则一定是浅拷贝。
    public static void main(String[] args) {
        Age a=new Age(20);
        Person p1=new Person(a,"摇头耶稣");
        Person p2=new Person(p1);  //进行了拷贝操作
        System.out.println("p1是"+p1);


        //修改p1的各属性值，观察p2的各属性值是否跟随变化
        p1.setName("小傻瓜");
        a.setAge(99);
        System.out.println("修改后的p1是"+p1);
        System.out.println("修改后的p2是"+p2);
    }



}

class Person{
    //两个属性值：分别代表值传递和引用传递
    private Age age;
    private String name;
    public Person(Age age,String name) {
        this.age=age;
        this.name=name;
    }
    //拷贝构造方法
    public Person(Person p) {
        this.name=p.name;
        this.age=p.age;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String toString() {
        return this.name+" "+this.age;
    }
}

class Age{
    private int age;
    public Age(int age) {
        this.age=age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return getAge()+"";
    }
}
