package jgame.world.maps;

import jgame.collision.TileType;
import jgame.collision.Wall;
import jgame.containers.SizeDimensions;
import jgame.containers.Vector;
import jgame.entities.common.EntityManager;
import jgame.entities.common.EntityType;
import jgame.entities.enemies.Enemy;
import jgame.entities.enemies.EnemyController;
import jgame.entities.enemies.EnemyProperties;
import jgame.entities.enemies.EnemyState;
import jgame.entities.player.Player;
import jgame.entities.player.PlayerController;
import jgame.world.TileManager;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MapsManager {
    private final ArrayList<MapData> mapsData;
    private final int[] mapPixelData;

    private EntityType player = null;
    private final ArrayList<TileType> tiles = new ArrayList<TileType>();
    private final ArrayList<EntityType> enemies = new ArrayList<EntityType>();
    private final EnemyController enemyController = new EnemyController();

    private EntityManager entityManager;
    private TileManager tileManager;

    // Temporary initialisation style. Will always launch first map in array (reason for hardcoded 0)
    public MapsManager(ArrayList<String> mapResourceNames) {
        this.mapsData = parseMapResourcesToData(mapResourceNames);
        mapPixelData = mapsData.get(0).getPixelsData();
        determineMapLayout(mapsData.get(0));
    }

    private ArrayList<MapData> parseMapResourcesToData(ArrayList<String> mapResourceNames) {
        ArrayList<MapData> mapsDataArray = new ArrayList<MapData>();
        for (String mapResourceName : mapResourceNames) {
            try {
                mapsDataArray.add(new MapData(mapResourceName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return mapsDataArray;
    }

    private ArrayList<MapData> getBufferedMapImages() {
        if (mapsData == null) {
            String preconditionCrashMessage = "Map Data not found";
            throw new RuntimeException(preconditionCrashMessage);
        }
        return mapsData;
    }

    private void determineMapLayout(MapData mapData) {
        int width = mapData.getMapWidth();
        int height = mapData.getMapHeight();
        int[] tileAndEntityPlacements = mapData.getPixelsData();

        int currentRow = 0;
        int currentColumn = -1;

        for (int i = 0; i < tileAndEntityPlacements.length; i++) {
            currentColumn++;
            if (i % width == 0 && i > 1) {
                currentRow++;
                currentColumn = 0;
            }

            int xPos = currentColumn * MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE;
            int yPos = currentRow * MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE;

            checkPixelIndexForPlayer(i, xPos, yPos);
            checkPixelIndexForTile(i, xPos, yPos);
            checkPixelIndexForEnemy(i, xPos, yPos);
        }
        entityManager = new EntityManager(enemies, player);
        tileManager = new TileManager(tiles);
    }

    private void checkPixelIndexForEnemy(int index, int xPos, int yPos) {
        if (mapPixelData[index] == MapDataPresets.ENEMY_CHANNEL) {
            // TODO: - Add predefined fields for enemy properties. Different color channels for enemyProperty presets...
            EnemyProperties enemyProperties = new EnemyProperties(3, 10, xPos, yPos, 64, EnemyState.idle, 250);
            Enemy enemy = new Enemy(enemyController, enemyProperties);
            enemies.add(enemy);
        }
    }

    private void checkPixelIndexForTile(int index, int xPos, int yPos) {
        if (mapPixelData[index] == MapDataPresets.TILE_CHANNEL) {
            Wall wall = new Wall(xPos, yPos, MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE, MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE, Color.DARK_GRAY);
            tiles.add(wall);
        }
    }

    private void checkPixelIndexForPlayer(int index, int xPos, int yPos) {
        if (mapPixelData[index] == MapDataPresets.PLAYER_CHANNEL) {
            PlayerController pc = new PlayerController();
            Vector vector = new Vector(xPos, yPos);
            SizeDimensions sd = new SizeDimensions(MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE, MapDataPresets.TILE_AND_ENTITY_PIXEL_SIZE);
            player = new Player(pc, vector, sd);
            enemyController.setEntity(player);
        }
    }

    // MARK: - Getters

    public TileManager getTileManager() {
        if (tileManager == null) {
            throw new RuntimeException("Tile manager not found");
        }
        return tileManager;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            throw new RuntimeException("Entity manager not found");
        }
        return entityManager;
    }
}