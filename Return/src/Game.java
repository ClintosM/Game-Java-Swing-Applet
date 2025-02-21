import javax.swing.*;
import java.awt.*;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Game {
    public static boolean isRunning = false;
    private static GameFrame frame;
    private static Player player;
//    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public Game() {
        if (!isRunning && Game.frame == null && player == null) {
            Game.frame = new GameFrame();
            Game.player = new Player(40, 40);
            isRunning = true;
        }
    }

    private void startRenderThreads() {
//        executor.submit(new PanelsRunnable("Runnable 1", frame, 0, 0));
//        executor.submit(new PanelsRunnable("Runnable 2", frame, frame.getWidth() / 2, 0));
//        executor.submit(new PanelsRunnable("Runnable 3", frame, frame.getWidth() / 2, frame.getHeight() / 2));
//        executor.submit(new PanelsRunnable("Runnable 4", frame, 0, frame.getHeight() / 2));
//        executor.shutdown();
    }

    public void gameLoop() throws InterruptedException {
        double startTime = System.currentTimeMillis();

//        Thread renderer = new Thread(new Renderer(frame, player, isRunning));
//        renderer.start();
        frame.setVisible(true);

//        while (renderer.isAlive()) {
//            Thread.sleep(1);
//        }

        System.out.println("=======================================================");
        double timeTaken = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Total time to complete rendering: " + timeTaken + " seconds...");
    }
}