package SE.objectCopy;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 测试深复制
 *
 *
 *


浅拷贝是指在拷贝对象时，对于基本数据类型的变量会重新复制一份，而对于引用类型的变量只是对引用进行拷贝，

没有对引用指向的对象进行拷贝。

而深拷贝是指在拷贝对象时，同时会对引用指向的对象进行拷贝。

区别就在于是否对  对象中的引用变量所指向的对象进行拷贝。
 * @Date 20:09 2019/4/18
 **/
public class TestCopy3 {


    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address();
        address.setAdd("上海");

        S_2 s_2 = new S_2();
        s_2.setAddress(address);
        s_2.setNumber(555);

        S_2 s_21 = (S_2) s_2.clone();

        System.out.println("1 : " + s_2.getAddress().getAdd() + "  " + s_2.getNumber());
        System.out.println("2 : " + s_21.getAddress().getAdd() + "  " + s_21.getNumber());

        System.out.println("******************");
        address.setAdd("北京");

        System.out.println("1 : " + s_2.getAddress().getAdd() + "  " + s_2.getNumber());
        System.out.println("2 : " + s_21.getAddress().getAdd() + "  " + s_21.getNumber());

        System.out.println("******************");
        address.setAdd("天津");

        System.out.println("1 : " + s_2.getAddress().getAdd() + "  " + s_2.getNumber());
        System.out.println("2 : " + s_21.getAddress().getAdd() + "  " + s_21.getNumber());




    }

}
class Address implements Cloneable{
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Address address = null;
        address = (Address) super.clone();
        return address;
    }
}
class S_2 implements Cloneable{

    private int number;

    private Address address;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        S_2 s_2 = null;
        s_2 = (S_2) super.clone();
        s_2.address = (Address) address.clone();
        return s_2;
    }
}
