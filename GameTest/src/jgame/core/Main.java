package jgame.core;

import jgame.world.maps.MapsManager;

import java.util.ArrayList;

public class Main {

    private static final GameFrame frame = new GameFrame(new FrameDelegate());

    public static void main(String[] args) {
        MapsManager mapsManager = setupMaps();
        launchGame(mapsManager);
    }

    private static void launchGame(MapsManager mapsManager) {
        Game game = new Game(true, frame, mapsManager.getTileManager(), mapsManager.getEntityManager());
        new Thread(new Render(game)).start();
        frame.setVisible(true);
    }

    private static MapsManager setupMaps() {
        ArrayList<String> mapResources = new ArrayList<String>();
        mapResources.add("map2");
        return new MapsManager(mapResources);
    }
}