import javax.swing.*;
import java.awt.*;
import java.util.Random;

class PanelsRunnable implements Runnable {
    private final String name;
    private final int startX;
    private final int startY;
    private final GameFrame frame;

    public PanelsRunnable(String name, GameFrame frame, int startX, int startY) {
        this.name = name;
        this.frame = frame;
        this.startX = startX;
        this.startY = startY;
    }

    @Override
    public void run() {
        addPanels();
    }

    public void addPanels() {
        int endX, endY;
        int panelSize = frame.getWidth() >> 7;

        endX = startX == 0 ? (frame.getWidth() / 2) : frame.getWidth();
        endY = startY == 0 ? (frame.getHeight() / 2) : frame.getHeight();

        for (int y = startY; y < endY; y += panelSize) {
            for (int x = startX; x < endX; x += panelSize) {
                Color color = new Color(new Random().nextInt());

                JPanel panel = new JPanel();
                panel.setBackground(color);
                panel.setLocation(x, y);
                panel.setSize(panelSize, panelSize);

                frame.add(panel);
                frame.repaint();
            }
        }
        System.out.println(name + " Completed task");
    }
}