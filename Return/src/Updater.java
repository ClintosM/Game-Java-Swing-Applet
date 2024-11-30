public class Updater implements Runnable {
    boolean isRunning;

    public Updater(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        while(isRunning) {
            update();
        }
    }

    private synchronized void update() {
        System.out.println("Ms Time: " + System.currentTimeMillis());
        // TODO: - Add logic for updating every step/frame
    }
}
