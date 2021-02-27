package demo.thread.race;

public abstract class Animal extends Thread {

    public int length = 200;

    public CallStop callStop;

    public abstract void running() throws InterruptedException;

    @Override
    public void run() {
        super.run();
        while (length > 0) {
            try {
                running();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
                break;
            }
        }
    }
}
