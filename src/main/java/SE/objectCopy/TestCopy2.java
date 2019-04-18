package SE.objectCopy;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 * 一般步骤是（浅复制）：

1. 被复制的类需要实现Clonenable接口（不实现的话在调用clone方法会抛出CloneNotSupportedException异常) 该接口为标记接口(不含任何方法)

2. 覆盖clone()方法，访问修饰符设为public。方法中调用super.clone()方法得到需要的复制对象，（native为本地方法)
 * @Date 20:05 2019/4/18
 **/
public class TestCopy2 {

    public static void main(String[] args) throws CloneNotSupportedException {
        S1 s1 = new S1();
        s1.setNumber(500);
        S1 s11 = (S1) s1.clone();
        //复制之后两个不同对象

        System.out.println(s1.getNumber());
        System.out.println(s11.getNumber());

        System.out.println("**************************");

        s1.setNumber(600);

        System.out.println(s1.getNumber());
        System.out.println(s11.getNumber());

    }

}

class S1 implements Cloneable{
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        S1 s1 = null;
        s1 = (S1) super.clone();
        return s1;
    }
}
