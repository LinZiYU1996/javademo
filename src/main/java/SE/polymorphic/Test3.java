package SE.polymorphic;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * java 多态
 * @Date 16:32 2019/4/14
 **/
public class Test3 {

    public static void main(String[] args) {
        P3 p3 = new C3();
        p3.DO();
    }

}
class  P3{
    public void DO(){
        System.out.println("P");
    }
}

class C3 extends P3{
    @Override
    public void DO() {
        System.out.println("C");
    }
}