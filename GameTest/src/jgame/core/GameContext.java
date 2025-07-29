package jgame.core;

import jgame.collision.TileType;
import jgame.entities.common.EntityType;

import java.util.ArrayList;

public class GameContext {
    public final ArrayList<TileType> tiles;
    public final ArrayList<EntityType> enemies;
    public final EntityType player;

    public GameContext(ArrayList<TileType> tiles,
                       ArrayList<EntityType> enemies,
                       EntityType player) {
        this.tiles = tiles;
        this.enemies = enemies;
        this.player = player;
    }
}
