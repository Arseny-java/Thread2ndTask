import java.util.concurrent.Callable;

public class MyCall implements Callable<Integer> {
    private final int msgCount;
    private final String name;

    public MyCall(int messageNumber, String taskName) {
        this.msgCount = messageNumber;
        name = taskName;
    }

    @Override
    public Integer call() {
        Thread.currentThread().setName("Thread of " + name);
        int count = 0;
        try {
            while (count < msgCount) {

                Thread.sleep(2500);
                System.out.println("Всем привет! Я " + Thread.currentThread().getName());
                count++;
            }
        } catch (InterruptedException err) {

        }
        return msgCount;
    }
}
