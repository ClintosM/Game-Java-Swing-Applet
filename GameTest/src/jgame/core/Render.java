package jgame.core;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Render implements Runnable {
    private final Game game;
    private final GameCanvas canvas;

    // TODO: - Add some kind of deltaTime...
    private double lastTime = System.nanoTime();
    private final double targetFPS = 60.0;
    private final double tickRate = 1000000000.0 / targetFPS;

    public Render(Game game, GameCanvas canvas) {
        this.game = game;
        this.canvas = canvas;
    }

    @Override
    public void run() {
        canvas.createBufferStrategy(2);
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        while (game.isRunning) {
            double elapsedTime = System.nanoTime() - lastTime;
            if ((elapsedTime) >= tickRate) {
                lastTime += tickRate;

                // Update logic
                game.update();

                // Redrawing
                Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
                g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                game.render(g);

                g.dispose();
                bufferStrategy.show();
                Toolkit.getDefaultToolkit().sync();
            }
        }
    }
}
