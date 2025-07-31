package jgame.collision;

import jgame.containers.Position;
import jgame.containers.SizeDimensions;
import jgame.containers.SizeDimensionsType;
import jgame.core.render.interfaces.TileRenderable;

import java.awt.*;

public class Wall implements TileType, TileRenderable {
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

        Position pos = new Position(x, y);
        SizeDimensionsType size = new SizeDimensions(width, height);
        this.collidable = new Collidable(pos, size);
    }

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

    public CollidableType getCollidable() {
        return collidable;
    }

    // MARK: - Setters
    public void setTileColor(Color color) {
        this.color = color;
    }

    public void setTileLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setTileSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
