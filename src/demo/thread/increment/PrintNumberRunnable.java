package demo.thread.increment;

import java.util.Arrays;

public class PrintNumberRunnable implements Runnable {

    static private int printNum = 1;

    private final Object FLAG = "use for synchronized";

    private int threadId;

    public PrintNumberRunnable(int threadId) {
        super();
        this.threadId = threadId;
    }

    @Override
    public void run() {
        int endNumber = 99;
        int threadNumber = 3;
        int eachTimePrintCounts = 3;
        while (printNum <= endNumber) {
            synchronized (FLAG) {
            if (printNum / eachTimePrintCounts % threadNumber == threadId) {
                int[] a = {1, 2, 3};
                Arrays.stream(a).forEach(it -> {
                    System.out.println("线程" + threadId + "打印：" + printNum);
                    printNum++;
                });
//                }
                    FLAG.notifyAll();
                } else {
                    try {
                        FLAG.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
