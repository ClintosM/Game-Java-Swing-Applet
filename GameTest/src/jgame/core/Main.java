package jgame.core;

public class Main {
    private static final GameFrame frame = new GameFrame(new FrameDelegate());

    public static void main(String[] args) {
        Game game = new Game(true, frame);
        new Thread(new Render(game)).start();
        frame.setVisible(true);
    }
}