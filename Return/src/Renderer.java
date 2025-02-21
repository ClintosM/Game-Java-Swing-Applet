//public class Renderer implements Runnable {
//    private final boolean isRunning;
//    private final GameFrame frame;
//    private final Player player;
//
//    private final long updateTime = 1000;
//
//    public Renderer(GameFrame frame, Player player, boolean isRunning) {
//       this.frame = frame;
//       this.player = player;
//       this.isRunning = isRunning;
//    }
//
//    @Override
//    public void run() {
//        if (player == null) {
//            throw new IllegalStateException("Player cannot be null.");
//        }
//        try {
//            displayPlayer();
//            render();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void render() throws InterruptedException {
//        while (isRunning) {
//            double time = System.currentTimeMillis();
//            Thread.sleep(updateTime);
//            System.out.println("Renderer Started. Time since last update: " + (System.currentTimeMillis() - time) / 1000);
//            System.out.println("Player X: " + player.getXPos());
//            System.out.println("Player Y: " + player.getYPos());
//        }
//    }
//
//    private void displayPlayer() {
//        if (player != null) {
//            player.setLocation(player.getXPos(), player.getYPos());
//            player.setSize(32, 32);
//            frame.add(player);
//            frame.repaint();
//        }
//    }
//}
