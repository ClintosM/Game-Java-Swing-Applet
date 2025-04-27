import Collision.TileType;
import Collision.Wall;

import java.awt.*;
import java.util.ArrayList;

// TODO: Add image parsing system. (Convert PNG to usable raster data to determine map layout)

public class TileManager {
    private final ArrayList<TileType> tiles;

    public TileManager(int tileCountX, int tileCountY) {
        this.tiles = createTiles(tileCountX, tileCountY);
    }

    private ArrayList<TileType> createTiles(int tileCountX, int tileCountY) {
        ArrayList<TileType> tileList = new ArrayList<TileType>();
        int tileSize = 64;

        for (int x = 0; x < tileCountX * tileSize; x += tileSize) {
            TileType tile = new Wall(x, 0, tileSize, tileSize, Color.DARK_GRAY);
            tileList.add(tile);
        }
        for (int y = 64; y < tileCountY * tileSize; y += tileSize) {
            TileType tile = new Wall(0, y, tileSize, tileSize, Color.DARK_GRAY);
            tileList.add(tile);
        }
        return tileList;
    }

    public ArrayList<TileType> getTiles() {
        return tiles;
    }
}
