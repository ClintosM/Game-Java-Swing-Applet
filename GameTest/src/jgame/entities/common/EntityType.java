package jgame.entities.common;

import jgame.collision.TileType;
import jgame.containers.Position;
import jgame.containers.SizeDimensionsType;

import java.util.ArrayList;

public interface EntityType {
    public SizeDimensionsType getSize();

    public Position getPosition();
    public float getMovementSpeed();
    public float getHorizontalSpeed();
    public float getVerticalSpeed();

    public void setHorizontalSpeed(float newSpd);
    public void setVerticalSpeed(float newSpd);

    public void moveBy(float dx, float dy);

    public void checkCollisionState(ArrayList<TileType> tiles);
    public boolean isColliding();
}