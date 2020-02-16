package main.screen;

import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.game.entity.Entity;
import main.game.entity.Player;
import main.input.Keyboard;
import main.screen.menu.Menu;

/**
 * Game Screen that appears when the player chooses a level.
 * @author Jeff
 */
public class GameScreen extends Screen {
    private ArrayList<Entity> entityList;
    
    /**
     * Initialize the GameScreen.
     * @param gc
     * @param kb
     * @param screens
     */
    public GameScreen(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        entityList = new ArrayList<>();
        restart();
    }
    
    /**
     * Restart the game
     */
    private void restart() {
        entityList.clear();
        entityList.add(new Player(gc, kb));
    }
    
    /**
     * Update the GameScreen and its contents.
     */
    @Override
    public void update() {
        for(Entity e : entityList)
            e.update();
        
        if (kb.isDown("ESCAPE")) {
            screens.pop();
            ((Menu) screens.peek()).resetMenu();
        }
    }

    /**
     * Render the GameScreen and its contents using its GraphicsContext.
     */
    @Override
    public void render() {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
        for(Entity e : entityList)
            e.render();
    }

}
