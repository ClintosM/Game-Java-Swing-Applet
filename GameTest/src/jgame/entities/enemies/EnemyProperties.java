package jgame.entities.enemies;

import jgame.collision.EntitySize;
import jgame.containers.Vector;

public class EnemyProperties {
    final int health;
    final int speed;
    final Vector vector;
    final EntitySize size;

    EnemyState state;
    int sightRadius;

    public EnemyProperties(int speed,
                           int health,
                           float startX,
                           float startY,
                           int size,
                           EnemyState state,
                           int sightRadius) {
        this.speed = speed;
        this.health = health;
        this.vector = new Vector(startX, startY);
        this.size = new EntitySize(size, size);
        this.state = state;
        this.sightRadius = sightRadius;
    }
}
