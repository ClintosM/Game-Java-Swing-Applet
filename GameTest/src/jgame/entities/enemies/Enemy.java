package jgame.entities.enemies;

import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;
import jgame.entities.common.EntityType;

import javax.swing.*;
import java.awt.*;

public class Enemy implements EntityType {
    private final EnemyController controller;
    final EnemyProperties properties;

    public Enemy(EnemyController controller, EnemyProperties properties) {
        this.controller = controller;
        this.properties = properties;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(Color.YELLOW);
        graphics2D.fillRect(
                (int) getVector().getX(),
                (int) getVector().getY(),
                getSizeDimensions().getWidth(),
                getSizeDimensions().getHeight()
        );
    }

    public void moveTo(float dx, float dy) {
        float newX = properties.getVector().getX() + dx;
        float newY = properties.getVector().getY() + dy;
        properties.getVector().setVector(newX, newY);
    }

    @Override
    public Vector getVector() {
        return properties.getVector();
    }

    @Override
    public SizeDimensionsType getSizeDimensions() {
        return properties.getSize();
    }

    @Override
    public void update() {
        controller.update(this);
    }
}