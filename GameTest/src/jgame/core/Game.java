package jgame.core;

import jgame.collision.TileType;
import jgame.entities.common.EntityManager;
import jgame.entities.common.EntityType;
import jgame.world.TileManager;

public class Game {
    public final boolean isRunning;
    private final GameFrame frame;

    private final EntityManager entityManager;
    private final TileManager tileManager;

    public Game(boolean isRunning, GameFrame frame, TileManager tileManager, EntityManager entityManager) {
        this.isRunning = isRunning;
        this.frame = frame;
        this.entityManager = entityManager;
        this.tileManager = tileManager;
        setup();
    }

    public void update() {
        entityManager.getPlayer().update();
        for (EntityType enemy : entityManager.getEnemies()) {
            enemy.update();
        }

        for (TileType tile : tileManager.getTiles()) {
            entityManager.getPlayer().checkForCollisions(tile.getCollidable());
        }
    }

    private void setup() {
        addEntitiesToFrame();
        addTilesToFrame();
    }

    private void addEntitiesToFrame() {
        frame.addPlayer(entityManager.getPlayer());
        for (EntityType enemy : entityManager.getEnemies()) {
            frame.addEntity(enemy);
        }
    }

    private void addTilesToFrame() {
        frame.addTiles(tileManager.getTiles());
    }
}
