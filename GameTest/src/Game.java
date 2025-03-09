import Entities.EntityType;
import Entities.Player.Player;
import java.util.ArrayList;

public class Game {
    public final boolean isRunning;

    private final Player player;
    private final ArrayList<EntityType> enemies;

    public Game(boolean isRunning, Player player, ArrayList<EntityType> enemies) {
        this.isRunning = isRunning;
        this.player = player;
        this.enemies = enemies;
    }

    public void update() {
        player.update();

        for (EntityType enemy : enemies) {
            enemy.update();
        }
    }
}
