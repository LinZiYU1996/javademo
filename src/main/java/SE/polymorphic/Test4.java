package SE.polymorphic;


import java.util.Random;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *Java 多态
 * 多态是运行时行为，不是编译时行为。
 * @Date 16:37 2019/4/14
 **/
public class Test4 {

    public P4 generate(){
        Random random = new Random();
        int number = random.nextInt(3);
        switch (number){
            case 0:return new C4();
            case 1:return new C4_1();
            case 2:return new C4_2();
        }
        return null;
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        P4 p4 = test4.generate();
        p4.DO();
    }


}
class P4{
    public void DO(){
        System.out.println("P4");
    }
}

class C4 extends P4{
    @Override
    public void DO() {
        System.out.println("C4");
    }
}

class C4_1 extends P4{
    @Override
    public void DO() {
        System.out.println("C4_1");
    }
}

class C4_2 extends P4{
    @Override
    public void DO() {
        System.out.println("C4_2");
    }
}



















