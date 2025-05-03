package jgame.world.maps;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class MapData {
    private final String resourceName;
    private final int[] pixelsData;
    private int mapWidth;
    private int mapHeight;

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
        try {
            return ImageIO.read(new File("src/jgame/world/resources/maps/" + resourceName + ".png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
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
