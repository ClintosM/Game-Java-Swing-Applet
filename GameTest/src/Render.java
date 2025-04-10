public class Render implements Runnable {

    private final Game game;
    private double lastTime = System.nanoTime();

    // TODO: - Add some kind of deltaTime...
    private final double targetFPS = 60.0;
    private final double tickRate = 1000000000.0 / targetFPS;

    public Render(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (game.isRunning) {
            double elapsedTime = System.nanoTime() - lastTime;
            if ((elapsedTime) >= tickRate) {

                game.update();
                lastTime += tickRate;

            }
        }
    }
}
