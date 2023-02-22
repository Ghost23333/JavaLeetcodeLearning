package Algorithm_Experiment.RBTree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName Test01.java
 * @Description TODO
 * @createTime 2023年02月03日 12:30:00
 */
public class Test01 {
    public static void main(String[] args) {
        int[] arr = { 1,5,6,7,8,9,10,11,12,13,14,15};
        RedBlackTree redBlackTree = new RedBlackTree();
        for (int i = 0; i < arr.length; i++) {
            redBlackTree.insert(new Node(arr[i]));
        }
        System.out.println("树的高度： " + redBlackTree.root.height());
        System.out.println("左子树的高度： " + redBlackTree.root.left.height());
        System.out.println("右子树的高度： " + redBlackTree.root.right.height());
        System.out.println("层次遍历");
        redBlackTree.print();
        // 要删除节点
        Node node = redBlackTree.search(14);
        redBlackTree.delete(node);
        System.out.println("树的高度： " + redBlackTree.root.height());
        System.out.println("左子树的高度： " + redBlackTree.root.left.height());
        System.out.println("右子树的高度： " + redBlackTree.root.right.height());
        System.out.println("层次遍历");
        redBlackTree.print();
        node = redBlackTree.search(9);
        redBlackTree.delete(node);
        System.out.println("树的高度： " + redBlackTree.root.height());
        System.out.println("左子树的高度： " + redBlackTree.root.left.height());
        System.out.println("右子树的高度： " + redBlackTree.root.right.height());
        System.out.println("层次遍历");
        redBlackTree.print();
        node = redBlackTree.search(5);
        redBlackTree.delete(node);
        System.out.println("树的高度： " + redBlackTree.root.height());
        System.out.println("左子树的高度： " + redBlackTree.root.left.height());
        System.out.println("右子树的高度： " + redBlackTree.root.right.height());
        System.out.println("层次遍历");
        redBlackTree.print();
    }
}


