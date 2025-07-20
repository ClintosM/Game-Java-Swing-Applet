package jgame.core;

import jgame.world.maps.MapsManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GameCanvas canvas = new GameCanvas();
        GameFrame frame = new GameFrame(canvas);
        MapsManager mapsManager = setupMaps();

        launchGame(mapsManager, canvas);
        frame.setVisible(true);
        canvas.requestFocusInWindow();
    }

    private static void launchGame(MapsManager mapsManager, GameCanvas canvas) {
        Game game = new Game(true, mapsManager.getTileManager(), mapsManager.getEntityManager());
        canvas.addKeyListener(game.getPlayerKeyListener());
        new Thread(new Render(game, canvas)).start();
    }

    private static MapsManager setupMaps() {
        ArrayList<String> mapResources = new ArrayList<String>();
        mapResources.add("map1");
        return new MapsManager(mapResources);
    }
}