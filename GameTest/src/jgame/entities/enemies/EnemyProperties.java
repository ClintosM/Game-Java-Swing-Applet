package jgame.entities.enemies;

import jgame.containers.SizeDimensions;
import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;

import java.awt.*;

// TODO: - Add getters and setters (and make fields private)
public class EnemyProperties {
    private final int health;
    private final int speed;
    private final Vector vector;
    private final SizeDimensionsType size;

    private Color color = Color.YELLOW;

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
        this.size = new SizeDimensions(size, size);
        this.state = state;
        this.sightRadius = sightRadius;
    }

    // MARK: - Getters

    public int getHealth() {
        return health;
    }

    public int getSightRadius() {
        return sightRadius;
    }

    public int getSpeed() {
        return speed;
    }

    public Vector getVector() {
        return vector;
    }

    public EnemyState getState() {
        return state;
    }

    public SizeDimensionsType getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    // MARK: - Setters

    public void setColor(Color color) {
        this.color = color;
    }
}
