package demo.thread.concurrent;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TicketSellerOne {

    static List<String> tickets = new ArrayList<>();

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
                    synchronized (tickets) {
                        if (tickets.size() <= 0) {
                            LocalTime endTime = LocalTime.now();
                            System.out.println("终止时间：" + endTime + "。间隔：" + Duration.between(startTime, endTime).toMillis());
                            break;
                        }
                        System.out.println("销售了：" + tickets.remove(0));
                    }
                }
            };
            new Thread(runnable).start();
        }

    }

}
