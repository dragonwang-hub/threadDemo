package demo.thread.race;

public class Tortoise extends Animal {
    public Tortoise() {
        setName("乌龟");
    }

    @Override
    public void running() throws InterruptedException {
        int speed = 2;
        int totalDistance = length;
        length -= speed;
        System.out.println("乌龟本次跑了" + speed + "米，距离终点还有" + length + "米");

        if (length <= 0) {
            length = 0;
            System.out.println("乌龟成功到达终点，此次比赛胜利者是乌龟！");
            if (callStop != null) {
                callStop.win();
            }
        }

        try {
            sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            throw new InterruptedException("兔子已到达，通知乌龟比赛结束。");
        }
    }
}
