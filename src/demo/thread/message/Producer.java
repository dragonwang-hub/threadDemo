package demo.thread.message;

public class Producer implements Runnable {

    private MessageStorage messageStorage;
    private int index;

    public Producer(MessageStorage messageStorage, int index) {
        this.messageStorage = messageStorage;
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            String message = "Producer Thread Id:" + index + "添加消息：这是该线程的第" + i + "条消息。";
            messageStorage.set(message);
        }
    }
}
