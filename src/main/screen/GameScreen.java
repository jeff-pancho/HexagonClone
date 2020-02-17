package main.screen;

import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.game.entity.BackgroundPoly;
import main.game.entity.CenterHexagon;
import main.game.entity.Entity;
import main.game.entity.Player;
import main.input.Keyboard;
import main.screen.menu.Menu;

/**
 * Game Screen that appears when the player chooses a level.
 * @author Jeff
 */
public class GameScreen extends Screen {
    private ArrayList<Entity> entities;
    private double[] gameDir;
    
    /**
     * Initialize the GameScreen.
     * @param gc
     * @param kb
     * @param screens
     */
    public GameScreen(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        this.gameDir = new double[] {0d};
        entities = new ArrayList<>();
        restart();
    }
    
    /**
     * Restart the game
     */
    private void restart() {
        entities.clear();
        
        for(int i = 0; i < 6; i++)
            entities.add(new BackgroundPoly(gc, Game.CENTER_X, Game.CENTER_Y, gameDir, i));
        
        entities.add(new Player(gc, kb, gameDir));
        entities.add(new CenterHexagon(gc, Game.CENTER_X, Game.CENTER_Y, 60, gameDir));
    }
    
    /**
     * Update the GameScreen and its contents.
     */
    @Override
    public void update() {
        for(Entity curEnt : entities)
            curEnt.update();
        
        if (kb.isDown("ESCAPE")) {
            screens.pop();
            ((Menu) screens.peek()).resetMenu();
        }
        
        gameDir[0] += Math.PI / 100;
    }

    /**
     * Render the GameScreen and its contents using its GraphicsContext.
     */
    @Override
    public void render() {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
        for(Entity curEnt : entities)
            curEnt.render();
    }

}
