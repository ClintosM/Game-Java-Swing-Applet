package Collision;

import java.awt.*;

public interface TileType {
    // Setters
    void setTileColor(Color color);

    void setTileLocation(int x, int y);

    void setTileSize(int width, int height);

    // Getters
    int getTileX();

    int getTileY();
}