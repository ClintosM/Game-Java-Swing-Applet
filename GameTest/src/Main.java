import Containers.Vector;
import Entities.*;
import Entities.Enemies.Enemy;
import Entities.Enemies.EnemyController;
import Entities.Player.Player;
import Entities.Player.PlayerController;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static GameFrame frame;
    private static final Player player = new Player(new PlayerController(), new Vector(0, 0));
    private static ArrayList<EntityType> enemies;

    public static void main(String[] args) {
        boolean isRunning = true;

        frame = new GameFrame(new FrameDelegate());
        frame.addPlayer(player);
        frame.setVisible(true);

        enemies = createEnemies();
        addEntitiesToFrame();

        Game game = new Game(isRunning, player, enemies);
        new Thread(new Render(game)).start();
    }

    // TODO: - Refactor to have some type of EnemyManager delegate
    private static ArrayList<EntityType> createEnemies() {
        ArrayList<EntityType> enemyArrayList = new ArrayList<EntityType>();
        EnemyController enemyController = new EnemyController(player);
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int xPos = random.nextInt(frame.getWidth());
            int yPos = random.nextInt(frame.getHeight());

            Enemy enemy = createEnemy(enemyController, xPos, yPos);
            enemyArrayList.add(enemy);
        }
        return enemyArrayList;
    }

    private static Enemy createEnemy(EnemyController enemyController, int xPos, int yPos) {
        return new Enemy(enemyController, xPos, yPos);
    }

    private static void addEntitiesToFrame() {
        frame.addPlayer(player);

        for (EntityType enemy : enemies) {
            frame.addEntity(enemy);
        }
    }
}