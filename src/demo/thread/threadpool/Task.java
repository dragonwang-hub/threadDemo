package demo.thread.threadpool;

import java.time.LocalTime;

public class Task implements Runnable {
    private String taskName;

    public Task( String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println(LocalTime.now()+ ": run taskName = " + this.taskName + "   Thread" + Thread.currentThread().getId());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalTime.now()+ ": ==end== taskName = " + this.taskName + "   Thread" + Thread.currentThread().getId());
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                '}';
    }
}
