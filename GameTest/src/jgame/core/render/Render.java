package jgame.core.render;

import jgame.core.game.GameCanvas;
import jgame.core.game.GameWorld;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Render implements Runnable {
    private final GameCanvas canvas;
    private final GameWorld gameWorld;

    private double lastTime = System.nanoTime();
    private final double targetFPS = 60.0;
    private final double tickRate = 1000000000.0 / targetFPS;

    private boolean isRunning = true;

    public Render(GameWorld gameWorld, GameCanvas canvas) {
        this.gameWorld = gameWorld;
        this.canvas = canvas;
    }

    @Override
    public void run() {
        canvas.createBufferStrategy(2);
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        while (isRunning) {
            double elapsedTime = System.nanoTime() - lastTime;
            if ((elapsedTime) >= tickRate) {
                lastTime += tickRate;

                // Update logic
                gameWorld.update();

                // Redrawing
                Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
                g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gameWorld.render(g);

                g.dispose();
                bufferStrategy.show();
                Toolkit.getDefaultToolkit().sync();
            }
        }
    }

    public void stop() {
        isRunning = false;
    }
}
