package jgame.core.cache;

import jgame.collision.TileType;

import java.util.ArrayList;
import java.util.function.Consumer;

public class TileCache {
    private final ArrayList<TileType> tiles;

    public TileCache(ArrayList<TileType> tiles) {
        this.tiles = tiles;
    }

    public ArrayList<TileType> getTiles() {
        return tiles;
    }
}
