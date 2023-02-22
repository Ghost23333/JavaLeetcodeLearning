package Algorithm_Experiment.TaskScheduling;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName Task.java
 * @createTime 2023年02月03日 13:39:00
 */
public class Task implements Comparable<Task> {
    public int id;
    public int deadline;
    public int weight;

    public Task(int id, int deadline, int weight) {
        this.id = id;
        this.deadline = deadline;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", deadline=" + deadline +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Task newTask) { // 按惩罚由大到小排序，调用Arrays.sort时会用到
        return Integer.compare(newTask.weight, this.weight);
    }
}
