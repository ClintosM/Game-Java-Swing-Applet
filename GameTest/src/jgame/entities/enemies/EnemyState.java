package jgame.entities.enemies;

import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;
import jgame.entities.common.EntityState;

public final class EnemyState extends EntityState {
    public EnemyState(Position initialPosition, SizeDimensionsType size) {
        super(initialPosition, size);
    }
}
