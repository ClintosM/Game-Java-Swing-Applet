package jgame.collision;

import javax.swing.*;
import java.awt.*;

public class Wall extends JPanel implements TileType {
    private int x;
    private int y;

    public Wall(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.setTileSize(width, height);
        setTileColor(color);
        setTileLocation(x, y);
        this.setVisible(true);
    }

    @Override
    public void setTileColor(Color color) {
        this.setBackground(color);
    }

    @Override
    public void setTileLocation(int x, int y) {
        this.setLocation(x, y);
    }

    @Override
    public void setTileSize(int width, int height) {
        this.setSize(width, height);
    }

    public int getTileX() {
        return this.x;
    }

    public int getTileY() {
        return this.y;
    }
}
