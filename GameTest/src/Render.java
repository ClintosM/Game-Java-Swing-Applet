public class Render implements Runnable {

    private final Game game;
    private double lastTime = System.nanoTime();
    private final double nsPerUpdate = 1000000000.0 / 60.0;

    public Render(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (game.isRunning) {
            double elapsedTime = System.nanoTime() - lastTime;
            if ((elapsedTime) >= nsPerUpdate) {

                game.update();
                lastTime += nsPerUpdate;

            }
        }
    }
}
