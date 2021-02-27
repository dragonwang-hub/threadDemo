package demo.thread.station;

public class Station extends Thread {

    public Station(String name) {
        super(name);
    }

    static int totalTickCount = 20;

    static final Object FLAG = "the object use for synchronized";

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (FLAG) {
                if (totalTickCount > 0) {
                    totalTickCount--;
                    System.out.println("窗口：" + getName() + "售出一张票, 余票还有" + totalTickCount + "张。");
                } else {
                    System.out.println("窗口：" + getName() + "提示：票已售罄，请选择其他班次。");
                    break;
                }
            }
        }
    }
}
