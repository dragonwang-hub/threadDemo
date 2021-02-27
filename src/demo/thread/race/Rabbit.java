package demo.thread.race;

public class Rabbit extends Animal {

    public Rabbit() {
        setName("兔子");
    }

    @Override
    public void running() throws InterruptedException {
        int speed = 5;
        int totalDistance = length;
        length -= speed;
        System.out.println("兔子本次跑了" + speed + "米，距离终点还有" + length + "米");

        if (length <= 0) {
            length = 0;
            System.out.println("兔子成功到达终点，此次比赛胜利者是兔子！");
            if (callStop != null) {
                callStop.win();
            }
        }

        int interval = 20;
        try {
            if ((totalDistance - length) % interval == 0) {
                sleep(1000);
            } else {
                sleep(100);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            throw new InterruptedException("乌龟已到达，通知兔子比赛结束。");
        }
    }
}
