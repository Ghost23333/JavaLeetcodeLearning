package test;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName Counter.java
 * @Description TODO
 * @createTime 2022年03月20日 20:52:00
 */
public class Counter {
    private int x =0;

    // 计数方法
    public void count() throws InterruptedException {
        for(int i=0;i<1000;i++) {
            x = x+ 1;
        }
        System.out.println(Thread.currentThread().getName()+"--"+x);
        Thread.sleep(2000);
    }

    public static void main(String[] args) {
        // 定义线程实现接口
        Runnable runnable = new Runnable(){
            Counter counter = new Counter();
            @Override
            public void run() {
                try {
                    counter.count();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // 启动2个线程
        for(int i=0;i<2;i++) {
            new Thread(runnable).start();
        }
    }
}
