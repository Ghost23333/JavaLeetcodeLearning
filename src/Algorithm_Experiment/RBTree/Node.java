package Algorithm_Experiment.RBTree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName Node.java
 * @Description TODO
 * @createTime 2023年02月03日 12:29:00
 */
public class Node {
    public int key;
    public Color color;
    public Node left;
    public Node right;
    public Node parent;

    public Node() {
    }

    public Node(Color color) {
        this.color = color;
    }

    public Node(int key) {
        this.key = key;
        this.color = Color.Red;
    }

    /**
     * 求在树中节点的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left != RedBlackTree.NULL ? left.height() : 0, right != RedBlackTree.NULL ? right.height() : 0) + 1;
    }

    /**
     * 在以该节点为根节点的树中，求最小节点
     *
     * @return
     */
    public Node minimum() {
        Node pointer = this;
        while (pointer.left != RedBlackTree.NULL)
            pointer = pointer.left;
        return pointer;
    }

    @Override
    public String toString() {
        String position = "null";
        if (this.parent != RedBlackTree.NULL)
            position = this.parent.left == this ? "left" : "right";
        return "[key: " + key + ", color: " + color + ", parent: " + parent.key + ", position: " + position + "]";
    }
}

