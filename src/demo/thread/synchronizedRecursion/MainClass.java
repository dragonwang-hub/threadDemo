package demo.thread.synchronizedRecursion;

public class MainClass {
    public static void main(String[] args) {
        SynchronizedRecursion synchronizedRecursion = new SynchronizedRecursion();
        synchronizedRecursion.methodOne();
        System.out.println("==============================");
        synchronizedRecursion.methodTwo();
    }

}
