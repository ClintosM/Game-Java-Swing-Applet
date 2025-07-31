package jgame.entities.player;

import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;
import jgame.entities.common.EntityState;

public final class PlayerState extends EntityState {
    public PlayerState(Position initialPosition, SizeDimensionsType size) {
        super(initialPosition, size);
    }
}
