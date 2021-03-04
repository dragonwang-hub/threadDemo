package demo.thread.concurrent;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketSellerTwo {

    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 1; i <= 100000; i++) {
            tickets.add("票编号" + i);
        }
    }

    public static void main(String[] args) {
        LocalTime startTime = LocalTime.now();
        System.out.println("开始时间：" + startTime);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                while (true) {
                    String ticket = tickets.poll();
                    if (ticket == null) {
                        LocalTime endTime = LocalTime.now();
                        System.out.println("终止时间：" + endTime + "。间隔：" + Duration.between(startTime, endTime).toMillis());
                        break;
                    }
                    System.out.println("销售了：" + ticket);
                }
            };
            new Thread(runnable).start();
        }

    }

}
