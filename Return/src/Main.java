import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    private static final Game game = new Game();

    public static void main(String[] args) throws InterruptedException {
        game.gameLoop();
    }
}

