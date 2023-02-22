package Algorithm_Experiment;

import com.sun.tools.javac.Main;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName BinarySearchTreeTest.java
 * @Description TODO
 * @createTime 2023年02月02日 17:07:00
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        char []chars = new char[]{'5','4','8','#','#','6','9'};
        BinarySearchTree tree = new BinarySearchTree(chars);
        System.out.println("删除8前");
        tree.show();
        tree.delete(8);
        System.out.println("插入8后");
        tree.show();

    }
}
