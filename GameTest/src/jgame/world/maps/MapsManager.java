package jgame.world.maps;

import jgame.collision.TileType;
import jgame.collision.Wall;
import jgame.containers.Position;
import jgame.containers.SizeDimensions;
import jgame.containers.SizeDimensionsType;
import jgame.entities.common.interfaces.EntityType;
import jgame.entities.enemies.Enemy;
import jgame.entities.player.Player;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsManager {
    private final List<MapData> mapsData;

    public MapsManager(List<String> mapNames) {
        this.mapsData = parseMapResourcesToData(mapNames);
    }

    public MapObjects buildObjectsFromMap(String mapName) {
        MapData mapData = getMapData(mapName);
        int[] pixels = mapData.getPixelsData();
        int width = mapData.getMapWidth();

        ArrayList<TileType> tiles = new ArrayList<>();
        ArrayList<EntityType> enemies = new ArrayList<>();
        EntityType player = null;

        int currentRow = 0;
        int currentColumn = -1;

        for (int i = 0; i < pixels.length; i++) {
            currentColumn++;
            if (i % width == 0 && i > 1) {
                currentRow++;
                currentColumn = 0;
            }

            int x = currentColumn * MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE;
            int y = currentRow * MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE;
            int pixel = pixels[i];

            switch (pixel) {
                case MapDataPresets.PLAYER_CHANNEL -> {
                    Position pos = new Position(x, y);
                    SizeDimensions size = new SizeDimensions(MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE,
                            MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE);
                    player = new Player(pos, size);
                }
                case MapDataPresets.ENEMY_CHANNEL -> {
                    Position pos = new Position(x, y);
                    SizeDimensionsType size = new SizeDimensions(
                            MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE,
                            MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE
                    );
                    enemies.add(new Enemy(pos, size));
                }
                case MapDataPresets.TILE_CHANNEL -> {
                    tiles.add(new Wall(x, y, MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE,
                            MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE, Color.DARK_GRAY));
                }
            }
        }

        if (player == null) {
            throw new RuntimeException("Map must contain a player.");
        }

        return new MapObjects(player, enemies, tiles);
    }

    private MapData getMapData(String name) {
        return mapsData.stream()
                .filter(m -> m.getMapName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Map not found: " + name));
    }

    private List<MapData> parseMapResourcesToData(List<String> mapNames) {
        List<MapData> result = new ArrayList<>();
        for (String name : mapNames) {
            try {
                result.add(new MapData(name));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
