package jgame.entities.common;

import jgame.collision.EntitySize;
import jgame.containers.Vector;

public interface EntityType {
    public Vector getVector();

    public EntitySize getEntitySize();

    public void update();
}