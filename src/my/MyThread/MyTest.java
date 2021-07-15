package my.MyThread;

public class MyTest {
    public static void main(String[] args) {
        AtomicThread at = new AtomicThread();
        at.start();
        //主线程中也对该变量增加10000次
        for (int i = 0; i < 10000; i++) {
            at.count++;
        }
        //为了确保子线程执行完成，所以需要在这里睡一会
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count的最终结果是:" + at.count);

    }

}


class AtomicThread extends Thread {
    public volatile int count;   //设置位volatile

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        System.out.println("子线程添加完成");
    }
}