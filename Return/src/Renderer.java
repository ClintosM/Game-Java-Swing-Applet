public class Renderer implements Runnable {
    @Override
    public void run() {
        System.out.println("Renderer Started");
    }

    private synchronized void render() {
        // TODO: - Add logic for updating any pending render updates
    }
}
