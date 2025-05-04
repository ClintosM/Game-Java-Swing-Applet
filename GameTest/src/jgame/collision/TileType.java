package jgame.collision;

import java.awt.*;

public interface TileType {

    public void render(Graphics2D g);

    // Setters
    void setTileColor(Color color);

    void setTileLocation(int x, int y);

    void setTileSize(int width, int height);

    // Getters

    CollidableType getCollidable();

    int getTileX();

    int getTileY();
}