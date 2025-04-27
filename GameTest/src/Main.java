import Containers.Vector;
import Entities.*;
import Entities.Enemies.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static GameFrame frame = new GameFrame(new FrameDelegate());

    public static void main(String[] args) {
        Game game = new Game(true, frame);
        new Thread(new Render(game)).start();
        frame.setVisible(true);
    }
}