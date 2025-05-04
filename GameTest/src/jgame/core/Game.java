package jgame.core;

import jgame.collision.TileType;
import jgame.entities.common.EntityManager;
import jgame.entities.common.EntityType;
import jgame.world.TileManager;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game {
    public final boolean isRunning;
    private final EntityManager entityManager;
    private final TileManager tileManager;

    public Game(boolean isRunning, TileManager tileManager, EntityManager entityManager) {
        this.isRunning = isRunning;
        this.entityManager = entityManager;
        this.tileManager = tileManager;
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

    public void render(Graphics2D g) {
        entityManager.render(g);
        tileManager.render(g);
    }

    public KeyListener getPlayerKeyListener() {
        return entityManager.getPlayer().getKeyListener();
    }
}
