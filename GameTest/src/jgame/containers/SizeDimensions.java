package jgame.containers;

public class SizeDimensions implements SizeDimensionsType {
    private final int width;
    private final int height;

    public SizeDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
