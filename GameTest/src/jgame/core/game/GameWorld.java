package jgame.core.game;

import jgame.collision.TileType;
import jgame.core.render.interfaces.EntityRenderable;
import jgame.core.render.managers.TileRenderManager;
import jgame.core.render.interfaces.TileRenderable;
import jgame.core.render.managers.EntityRenderManager;
import jgame.entities.common.interfaces.EntityType;
import jgame.entities.enemies.Enemy;
import jgame.entities.enemies.EnemyController;
import jgame.entities.player.PlayerController;
import jgame.core.cache.EntityCache;
import jgame.core.cache.TileCache;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameWorld {
    private final PlayerController playerController;
    private final EnemyController enemyController;

    private final TileCache tileCache;
    private final EntityCache entityCache;

    private final EntityRenderManager entityRenderManager;
    private final TileRenderManager tileRenderManager;

    public GameWorld(
            EntityCache entityCache,
            TileCache tileCache,
            PlayerController pc,
            EnemyController ec
    ) {
        this.entityCache = entityCache;
        this.tileCache = tileCache;
        this.playerController = pc;
        this.enemyController = ec;

        this.entityRenderManager = setupEntityRenderManager(entityCache);
        this.tileRenderManager = setupTileRenderManager(tileCache);
    }

    private EntityRenderManager setupEntityRenderManager(EntityCache entityCache) {
        ArrayList<EntityRenderable> entityRenderables = new ArrayList<>();

        for (EntityType entity : entityCache.getAllEntities()) {
            if (entity instanceof EntityRenderable renderable) {
                entityRenderables.add(renderable);
            }
        }
        return new EntityRenderManager(entityRenderables);
    }

    private TileRenderManager setupTileRenderManager(TileCache tileCache) {
        ArrayList<TileRenderable> tileRenderables = new ArrayList<>();

        for (TileType tile : tileCache.getTiles()) {
            if (tile  instanceof TileRenderable renderable) {
                tileRenderables.add(renderable);
            }
        }
        return new TileRenderManager(tileRenderables);
    }

    public void update() {
        GameContext gameContext = new GameContext(
                entityCache,
                tileCache
        );
        updateEntities(gameContext);
    }

    private void updateEntities(GameContext gameContext) {
        playerController.update(gameContext);
        for (EntityType enemy : entityCache.getEnemies()) {
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
