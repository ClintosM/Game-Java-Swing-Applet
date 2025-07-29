package jgame.core;

import jgame.collision.TileType;
import jgame.entities.common.EntityManager;
import jgame.entities.common.EntityRenderManager;
import jgame.entities.common.EntityType;
import jgame.entities.enemies.Enemy;
import jgame.entities.enemies.EnemyController;
import jgame.entities.player.PlayerController;
import jgame.world.TileManager;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameWorld {
    private final PlayerController playerController;
    private final EnemyController enemyController;

    private final TileManager tileManager;
    private final EntityManager entityManager;

    private final EntityRenderManager entityRenderManager;
    private final TileRenderManager tileRenderManager;

    public GameWorld(
            EntityType player,
            ArrayList<EntityType> enemies,
            PlayerController pc,
            EnemyController ec,
            TileManager tm
    ) {
        this.playerController = pc;
        this.enemyController = ec;
        this.tileManager = tm;
        this.entityManager = new EntityManager(enemies, player);

        this.entityRenderManager = setupEntityRenderManager(entityManager);
        this.tileRenderManager = setupTileRenderManager(tileManager);
    }

    private EntityRenderManager setupEntityRenderManager(EntityManager entityManager) {
        ArrayList<EntityRenderable> entityRenderables = new ArrayList<>();

        for (EntityType entity : entityManager.getAllEntities()) {
            if (entity instanceof EntityRenderable renderable) {
                entityRenderables.add(renderable);
            }
        }
        return new EntityRenderManager(entityRenderables);
    }

    private TileRenderManager setupTileRenderManager(TileManager tileManager) {
        ArrayList<TileRenderable> tileRenderables = new ArrayList<>();

        for (TileType tile : tileManager.getTiles()) {
            if (tile  instanceof TileRenderable renderable) {
                tileRenderables.add(renderable);
            }
        }
        return new TileRenderManager(tileRenderables);
    }

    public void update() {
        GameContext gameContext = new GameContext(
                tileManager.getTiles(),
                entityManager.getEnemies(),
                entityManager.getPlayer()
        );

        playerController.update(gameContext);
        for (EntityType enemy : entityManager.getEnemies()) {
            enemyController.update((Enemy) enemy, gameContext);
        }
    }

    public void render(Graphics2D g) {
        tileRenderManager.render(g);
        entityRenderManager.render(g);
    }

    public KeyListener getKeyListener() {
        return playerController.getKeyListener();
    }
}
