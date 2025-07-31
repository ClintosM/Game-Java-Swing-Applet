package jgame.core.game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private final String TITLE = "JGame Test";
    private final GameCanvas canvas;

    public GameFrame(GameCanvas canvas) {
        this.canvas = canvas;
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Canvas Setup
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public GameCanvas getCanvas() {
        return canvas;
    }
}
