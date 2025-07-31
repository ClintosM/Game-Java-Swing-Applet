package jgame.core.game;

import jgame.collision.TileType;
import jgame.core.cache.EntityCache;
import jgame.core.cache.TileCache;
import jgame.entities.common.interfaces.EntityType;

import java.util.ArrayList;

public final class GameContext {
    private final EntityCache entityCache;
    private final TileCache tileCache;

    public GameContext(EntityCache entityCache,
                       TileCache tileCache) {
        this.entityCache = entityCache;
        this.tileCache = tileCache;
    }

    public ArrayList<TileType> getTiles() {
        return tileCache.getTiles();
    }

    public ArrayList<EntityType> getAllEntities() {
        return entityCache.getAllEntities();
    }

    public EntityType getPlayer() {
        return entityCache.getPlayer();
    }

    public ArrayList<EntityType> getAllEnemies() {
        return entityCache.getEnemies();
    }
}
