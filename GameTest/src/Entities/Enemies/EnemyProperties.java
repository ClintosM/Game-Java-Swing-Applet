package Entities.Enemies;

import Containers.Vector;

public class EnemyProperties {
    final int health;
    final int speed;
    final Vector vector;

    EnemyState state;
    int sightRadius;

    public EnemyProperties(int speed,
                           int health,
                           float startX,
                           float startY,
                           EnemyState state,
                           int sightRadius) {
        this.speed = speed;
        this.health = health;
        this.vector = new Vector(startX, startY);
        this.state = state;
        this.sightRadius = sightRadius;
    }
}
