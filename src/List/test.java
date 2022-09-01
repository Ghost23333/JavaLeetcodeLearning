package List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName test.java
 * @Description TODO
 * @createTime 2022年03月08日 14:29:00
 */
public class test {

    public static void main(String[] args) {
        Love love = (int a) ->{
            System.out.println("i love you" + a);
        };
        love.love(1);
    }
}



interface Love{
    void love(int a);
}