package Entities;
import Containers.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Player extends JPanel implements EntityType {
    private Vector vector;
    private final PlayerController controller;

    public Player(PlayerController controller, Vector vector) {
        this.controller = controller;
        this.vector = vector;
        setProperties();
    }

    private void setProperties() {
        setSize(64, 64);
        setBackground(Color.BLUE);
        setLocation((int)vector.getX(), (int)vector.getY());
        setVisible(true);
    }

    public KeyListener getKeyListener() {
        return (KeyListener) controller;
    }

    public void moveTo(float dx, float dy) {
        vector.setX(vector.getX() + dx);
        vector.setY(vector.getY() + dy);
        setLocation((int)vector.getX(), (int)vector.getY());
    }

    public Vector getVector() {
        return this.vector;
    }

    @Override
    public void update() {
        controller.update(this);
    }
}

