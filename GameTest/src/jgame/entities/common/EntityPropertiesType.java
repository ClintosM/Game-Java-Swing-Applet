package jgame.entities.common;

import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;

public interface EntityPropertiesType {
    public Vector getVector();
    public  SizeDimensionsType getSize();

    public float getCurrentSpd();
    public float getMaxSpd();
}
