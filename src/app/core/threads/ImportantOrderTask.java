package app.core.threads;

public class ImportantOrderTask implements Runnable {

    //TODO -- Reminder obj
    private String reminder;


    public ImportantOrderTask(String reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {

    }
}
