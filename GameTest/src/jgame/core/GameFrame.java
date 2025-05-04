package jgame.core;

import jgame.collision.TileType;
import jgame.entities.player.Player;
import jgame.entities.common.EntityType;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;
import java.util.ArrayList;

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
