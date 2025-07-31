package jgame.world.maps;

import jgame.collision.TileType;
import jgame.entities.common.interfaces.EntityType;

import java.util.ArrayList;

public record MapObjects(
        EntityType player,
        ArrayList<EntityType> enemies,
        ArrayList<TileType> tiles) {
}
