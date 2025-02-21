import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Player extends JPanel {
    private int xPos;
    private int yPos;

    public Player(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    private void setPlayer() {
        this.setBackground(Color.BLUE);
        this.setSize(32, 32);
        this.setVisible(true);
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}