package SE.objectCopy;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 简单的复制
 * @Date 20:02 2019/4/18
 **/
public class TestCopy1 {


    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.setNumber(1);

        T1 t11 = t1;
        System.out.println(t1.getNumber());
        System.out.println(t11.getNumber());

        System.out.println("----------------------------");

        t1.setNumber(222);

        System.out.println(t1.getNumber());
        System.out.println(t11.getNumber());

    }
}

class T1{
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
