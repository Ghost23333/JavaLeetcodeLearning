package Algorithm_Experiment.RBTree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName Color.java
 * @Description TODO
 * @createTime 2023年02月03日 12:25:00
 */
public enum Color {
    Black("黑色"), Red("红色");

    private String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
