package SE.innerClass;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 匿名内部类
 * @Date 16:17 2019/4/18
 **/
public class TestStaticInnerClass3 {
    public void test(Bird bird){
        System.out.println(bird.getName() + "飞" + bird.fly() + "米");

    }

    public static void main(String[] args) {
        TestStaticInnerClass3 testStaticInnerClass3 = new TestStaticInnerClass3();
        testStaticInnerClass3.test(new Bird() {
            @Override
            public int fly() {
                return 100000;
            }

            public String getName() {
                return "小鸟";
            }

        });
    }

}
abstract  class Bird{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}