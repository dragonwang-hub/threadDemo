package demo.thread.reentrant;

public class MainClass {
    public static void main(String[] args) {
        Runnable runnable = new RunnableOne();
        Thread threadOne = new Thread(runnable);
        Thread threadTwo = new Thread(runnable);
        Thread threadThree = new Thread(runnable);
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
