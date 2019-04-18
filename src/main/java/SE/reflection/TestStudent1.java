package SE.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 *获取类中的所有方法
 * @Date 9:43 2019/4/18
 **/
public class TestStudent1 {

    //Class.forName("fs.Student")：初始化指定的类
    //clz.getMethods()：获取类中所有的方法(包括其继承类的方法)
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> clazz = Class.forName("SE.reflection.Person");
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            System.out.println("方法名字" + method.getName()); //包括object里面的方法
        }

        System.out.println("--------------------------------");

        //如果只需要获取加载类中的方法，不要父类的方法，可以使用下面的代码：
        Method[] methods1 = clazz.getDeclaredMethods();
        for(Method method : methods1){
            System.out.println("方法名字" + method.getName()); //包括object里面的方法
        }

        //Method是方法类，可以获取方法相关的信息，除了我们上面的方法名称，我们还可以获取其他的一些信息，比如：
        //
        //方法返回类型：method.getReturnType().getName()
        //方法修饰符：Modifier.toString(method.getModifiers())
        //方法参数信息： method.getParameters()
        //方法上的注解： method.getAnnotations()
        //等等.......

        System.out.println("-----------------------------------------------------");
        //除了可以获取Class中方法的信息，还可以通过反射来调用方法，接下来看看怎么调用方法：
        Person person = (Person) clazz.newInstance();
        System.out.println(person.getName());
        Method method = clazz.getMethod("setName", String.class);
        method.invoke(person,"HHH");
        System.out.println(person.getName());


        System.out.println("-------------------------------");
        //获取类中的所有属性

        //clz.getFields()只能获取public的属性，包括父类的。
        //如果需要获取自己声明的各种字段，包括public，protected，private得用clz.getDeclaredFields()
        //Field是属性类，可以获取属性相关的信息，比如：
        //
        //属性类型：field.getType().getName()
        //属性修饰符：Modifier.toString(field.getModifiers())
        //属性上的注解： field.getAnnotations()
        //等等.......
        Field[] fields = clazz.getFields();
        for(Field field : fields){
            System.out.println("属性名" + field.getName());
        }


        //操作属性
        System.out.println("---------------------------------");
        Person person1 = (Person) clazz.newInstance();
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(person1));
        field.set(person1,"PPP");
        System.out.println(field.get(person1));




    }

}
