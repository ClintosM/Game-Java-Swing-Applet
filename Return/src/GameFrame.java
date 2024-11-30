import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private final static int WIDTH = 1280;
    private final static int HEIGHT = WIDTH / 16 * 9;
    private final static String TITLE = "GAME LOOP PROJECT";

    public GameFrame() {
        this.setSize(new Dimension(GameFrame.WIDTH, GameFrame.HEIGHT));
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle(GameFrame.TITLE);
    }

    public void resetAll() {
        removeAll();
        revalidate();
        repaint();
    }
}
