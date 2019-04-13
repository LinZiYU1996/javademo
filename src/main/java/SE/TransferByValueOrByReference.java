package SE;



/*
*
 * @Author Mr.Lin
 * @Description //Java值传递还是引用传递
 * @Date 21:46 2019/4/13
 **/
public class TransferByValueOrByReference {


    public static void swap(Integer integer1,Integer integer2){
        Integer temp;
        temp = integer1;
        integer1 = integer2;
        integer2 = temp;

    }

    public static void main(String[] args) {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(2);
        swap(integer1,integer2);
        System.out.println(integer1+"***"+integer2);//显示没有交换

    }





}
