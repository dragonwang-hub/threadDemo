package demo.thread.station;

public class MainClass {
    public static void main(String[] args) {
        Station station1 = new Station("1号窗口");
        Station station2 = new Station("2号窗口");
        Station station3 = new Station("3号窗口");

        station1.start();
        station2.start();
        station3.start();
    }
}
