package demo.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 20,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new Reject());

//        ExecutorService threadPoolExecutor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            String name = "任务" + i + "号";
            Task task = new Task(name);
            System.out.println(name + "创建成功！");
            threadPoolExecutor.execute(task);
        }
        threadPoolExecutor.shutdown();

    }

}
