package jgame.core.game;

import java.awt.*;

public class GameCanvas extends Canvas {
    public GameCanvas() {
        setPreferredSize(new Dimension(1920, 1080));
        setIgnoreRepaint(true);
        setFocusable(true);
        requestFocusInWindow();
    }
}
