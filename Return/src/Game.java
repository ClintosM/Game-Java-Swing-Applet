import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Game {
    public static boolean isRunning = false;
    private static GameFrame frame;

    private final ExecutorService executor = Executors.newFixedThreadPool(4);
//    private final BufferedImage bufferedImage = new BufferedImage();

    public Game() {
        if (!isRunning && Game.frame == null) {
            Game.frame = new GameFrame();
            isRunning = true;
        }
    }

    private void startThreads() {
        executor.submit(new PanelsRunnable("Runnable 1", frame, 0, 0));
        executor.submit(new PanelsRunnable("Runnable 2", frame, frame.getWidth() / 2, 0));
        executor.submit(new PanelsRunnable("Runnable 3", frame, frame.getWidth() / 2, frame.getHeight() / 2));
        executor.submit(new PanelsRunnable("Runnable 4", frame, 0, frame.getHeight() / 2));
        executor.shutdown();
    }

    public void gameLoop() throws InterruptedException {
        frame.setVisible(true);

        double startTime = System.currentTimeMillis(); startThreads();

        while (!executor.isTerminated()) Thread.sleep(1);

        System.out.println("=======================================================");
        double timeTaken = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Total time to complete rendering: " + timeTaken + " seconds...");
    }
}

