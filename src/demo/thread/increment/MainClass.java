package demo.thread.increment;

import java.util.stream.IntStream;

public class MainClass {
    public static void main(String[] args) {
        new Thread(new PrintNumberRunnable(0)).start();
        new Thread(new PrintNumberRunnable(1)).start();
        new Thread(new PrintNumberRunnable(2)).start();
    }
}
