package Entities.Enemies;

import Containers.Vector;
import Entities.EntityType;

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
        setSize(64, 64);
        setBackground(Color.RED);
        setLocation((int) properties.vector.getX(), (int) properties.vector.getY());
        setVisible(true);
    }

    public void moveTo(float dx, float dy) {
        float newX = properties.vector.getX() + dx;
        float newY = properties.vector.getY() + dy;
        properties.vector.setVector(newX, newY);
        setLocation((int) properties.vector.getX(), (int) properties.vector.getY());
    }

    @Override
    public Vector getVector() {
        return properties.vector;
    }

    @Override
    public void update() {
        controller.update(this);
    }
}