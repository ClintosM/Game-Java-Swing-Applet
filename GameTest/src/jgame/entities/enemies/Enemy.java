package jgame.entities.enemies;

import jgame.containers.SizeDimensionsType;
import jgame.containers.Vector;
import jgame.entities.common.EntityType;

import javax.swing.*;
import java.awt.*;

public class Enemy extends JPanel implements EntityType {
    private final EnemyController controller;
    final EnemyProperties properties;

    public Enemy(EnemyController controller, EnemyProperties properties) {
        this.controller = controller;
        this.properties = properties;
        setupJPanel();
    }

    private void setupJPanel() {
        setSize(properties.getSize().getWidth(), properties.getSize().getHeight());
        setBackground(Color.RED);
        setLocationWithVector();
        setVisible(true);
    }

    public void moveTo(float dx, float dy) {
        float newX = properties.getVector().getX() + dx;
        float newY = properties.getVector().getY() + dy;
        properties.getVector().setVector(newX, newY);
        setLocationWithVector();
    }

    private void setLocationWithVector() {
        setLocation((int) getVector().getX(), (int) getVector().getY());
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