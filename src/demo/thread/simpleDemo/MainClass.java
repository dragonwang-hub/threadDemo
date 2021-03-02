package demo.thread.simpleDemo;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        SimpleExample instanceOne = new SimpleExample();
        SimpleExample instanceTwo = new SimpleExample();

        Thread threadOne = new Thread(instanceOne);
        Thread threadTwo = new Thread(instanceTwo);

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("finished");
    }

}
