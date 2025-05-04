package jgame.world;

import jgame.collision.TileType;
import jgame.collision.Wall;

import java.awt.*;
import java.util.ArrayList;

public class TileManager {
    private final ArrayList<TileType> tiles;

    public TileManager(ArrayList<TileType> tiles) {
        this.tiles = tiles;
    }

    public ArrayList<TileType> getTiles() {
        return tiles;
    }

    public void render(Graphics2D g) {
        for (TileType tile : tiles) {
            tile.render(g);
        }
    }
}
