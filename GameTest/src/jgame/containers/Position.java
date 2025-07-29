package jgame.containers;

public class Position {
    private float x, y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
