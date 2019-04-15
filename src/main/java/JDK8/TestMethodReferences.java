package JDK8;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 测试java8 的方法引用
 *
 *
 *  方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法
 * 。方法引用提供了一种引用而不执行方法的方式，它需要由兼容的函数式接口构成的目标类型上下文。
 * 计算时，方法引用会创建函数式接口的一个实例。
当Lambda表达式中只是执行一个方法调用时，不用Lambda表达式
* ，直接通过方法引用的形式可读性更高一些。方法引用是一种更简洁易懂的Lambda表达式。
注意方法引用是一个Lambda表达式，其中方法引用的操作符是双冒号"::"。
*
*
*
*
 * @Date 19:57 2019/4/15
 **/
public class TestMethodReferences {

    public static void main(String[] args) {
        Person[] pArr = new Person[]{
                new Person("003", LocalDate.of(2016,9,1)),
                new Person("001", LocalDate.of(2016,2,1)),
                new Person("002", LocalDate.of(2016,3,1)),
                new Person("004", LocalDate.of(2016,12,1))};

        // 使用匿名类对它数组进行排序
        Arrays.sort(pArr, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        });

        System.out.println(Arrays.asList(pArr));
        System.out.println("--------------------------------------");
        //使用lambda表达式
        Arrays.sort(pArr, (Person a, Person b) -> {
            return a.getBirthday().compareTo(b.getBirthday());
        });

        System.out.println(Arrays.asList(pArr));
        System.out.println("--------------------------------------");
        //使用lambda表达式和类的静态方法
        Arrays.sort(pArr, (a ,b) -> Person.compareByAge(a, b));

        System.out.println(Arrays.asList(pArr));
        System.out.println("--------------------------------------");

        //使用方法引用
        Arrays.sort(pArr, Person::compareByAge);

        System.out.println(Arrays.asList(pArr));
    }


}



//定义一个Person类
class Person {

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    String name;
    LocalDate birthday;

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
