package Entities.Enemies;
import Containers.Vector;
import Entities.EntityType;

import javax.swing.*;
import java.awt.*;

public class Enemy extends JPanel implements EntityType {
    final Vector vector;
    private final EnemyController controller;
    EnemyState state = EnemyState.idle;

    public Enemy(EnemyController controller, float startX, float startY) {
        this.controller = controller;
        this.vector = new Vector(startX, startY);
        setProperties();
    }

    private void setProperties() {
        setSize(64, 64);
        setBackground(Color.RED);
        setLocation((int) vector.getX(), (int) vector.getY());
        setVisible(true);
    }

    public void moveTo(float dx, float dy) {
        float newX = vector.getX() + dx;
        float newY = vector.getY() + dy;
        vector.setVector(newX, newY);
        setLocation((int)vector.getX(), (int)vector.getY());
    }

    @Override
    public Vector getVector() {
        return vector;
    }

    @Override
    public void update() {
        controller.update(this);
    }
}