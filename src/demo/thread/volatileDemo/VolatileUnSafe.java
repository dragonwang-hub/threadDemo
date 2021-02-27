package demo.thread.volatileDemo;

class VolatileUnsafe {
    private static class VolatileVar implements Runnable {
        public static Object o = new Object();
        private volatile Boolean flag = true; //有volatile和没volatile效果明显

        @Override
        public void run() {
            while (true) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + ":>>>>>" + flag);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileVar v = new VolatileVar();
        Thread t1 = new Thread(v);
        Thread t2 = new Thread(v);
        Thread t3 = new Thread(v);
        Thread t4 = new Thread(v);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.sleep(10);
        v.flag = false;
        System.out.println("I sleep 5s\n==================\n");
        Thread.sleep(5000);
        System.out.println("I will start now");
        v.flag = true;
    }
}
