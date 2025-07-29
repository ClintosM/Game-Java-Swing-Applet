package jgame.world.maps;

import jgame.collision.TileType;
import jgame.entities.common.EntityType;

import java.util.ArrayList;

public record MapEntities(
        EntityType player,
        ArrayList<EntityType> enemies,
        ArrayList<TileType> tiles) {
}
