package jgame.world.maps;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import java.io.InputStream;

public class MapData {
    private final String resourceName;
    private final int[] pixelsData;
    private int mapWidth;
    private int mapHeight;

    private static final String PATH = "jgame/world/resources/maps/";
    private static final String EXTENSION = ".png";

    public MapData(String resourceName) throws IOException {
        this.resourceName = resourceName;
        this.pixelsData = setPixelData();
    }

    private int[] setPixelData() throws IOException {
        BufferedImage bufferedImage = parseBufferedImageFromResource(resourceName);
        Raster raster = bufferedImage.getRaster();
        setBounds(bufferedImage);
        return raster.getPixels(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), (int[]) null);
    }

    private void setBounds(BufferedImage bufferedImage) {
        this.mapWidth = bufferedImage.getWidth();
        this.mapHeight = bufferedImage.getHeight();
    }

    private BufferedImage parseBufferedImageFromResource(String resourceName) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream( PATH + resourceName + EXTENSION);
        if (in == null) {
            throw new RuntimeException("Resource not found: " + resourceName);
        }
        return ImageIO.read(in);
    }

    // MARK: - Public Getters

    public int[] getPixelsData() {
        return pixelsData;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }
}