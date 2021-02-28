package demo.thread.message;

public class Consumer implements Runnable {

    private MessageStorage messageStorage;
    private int index;

    public Consumer(MessageStorage messageStorage, int index) {
        this.messageStorage = messageStorage;
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            messageStorage.get();
        }
    }
}
