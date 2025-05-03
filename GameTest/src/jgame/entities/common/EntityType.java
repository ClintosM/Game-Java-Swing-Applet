package jgame.entities.common;

import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;

public interface EntityType {
    public Vector getVector();

    public SizeDimensionsType getSizeDimensions();

    public void update();
}