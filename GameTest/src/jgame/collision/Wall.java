package jgame.collision;

import jgame.containers.SizeDimensions;
import jgame.containers.Vector;

import java.awt.*;

public class Wall implements TileType {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    private final CollidableType collidable;

    public Wall(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.collidable = new Collidable(new Vector(x, y), new SizeDimensions(width, height));
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    // MARK: - Getters

    public int getTileX() {
        return this.x;
    }

    public int getTileY() {
        return this.y;
    }

    @Override
    public CollidableType getCollidable() {
        return collidable;
    }

    // MARK: - Setters
    @Override
    public void setTileColor(Color color) {
        this.color = color;
    }

    @Override
    public void setTileLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setTileSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
