package main.screen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import main.game.entity.BackgroundPoly;
import main.game.entity.CenterHexagon;
import main.game.entity.Deletable;
import main.game.entity.Entity;
import main.game.entity.Player;
import main.game.entity.Wall;
import main.input.Keyboard;
import main.screen.menu.Menu;
import main.ui.Palette;

/**
 * Game Screen that appears when the player chooses a level.
 * @author Jeff
 */
public class GameScreen extends Screen {
    private ArrayList<Entity> entities;
    private double[] gameDir;
    private Random rd;
    
    /** Interval for spawning Walls. */
    private int count;
    
    private Palette bgPalette1;
    private Palette bgPalette2;
    private Palette plrPalette;
    
    /**
     * Initialize the GameScreen.
     * @param gc
     * @param kb
     * @param screens
     */
    public GameScreen(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        this.gameDir = new double[] {0d};
        this.entities = new ArrayList<>();
        this.count = 30;
        this.rd = new Random();
        
        bgPalette1 = new Palette(Color.BLACK, Color.PINK);
        bgPalette2 = new Palette(Color.BLACK, Color.WHITE);
        plrPalette = new Palette(Color.BLACK, Color.BLACK);
        
        restart();
    }
    
    /**
     * Restart the game
     */
    private void restart() {
        entities.clear();
        
        for(int i = 0; i < 6; i++) {
            Palette p = i % 2 == 0 ? bgPalette1 : bgPalette2;
            entities.add(new BackgroundPoly(gc, Game.CENTER_X, Game.HEIGHT + 100, gameDir, p, i));
        }
        
        entities.add(new Player(gc, kb, entities, gameDir, plrPalette));
        entities.add(new CenterHexagon(gc, Game.CENTER_X, Game.CENTER_Y, 60, gameDir, bgPalette2));
    }
    
    /**
     * Update the GameScreen and its contents.
     */
    @Override
    public void update() {
        if(count-- <= 0) {
            int randSide = rd.nextInt(6);
            for(int i = 0; i < 5; i++)
                entities.add(6, new Wall(gc, gameDir, plrPalette, (randSide + i) % 6, 800, 50));
            count = 45;
        }
        
        
        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()) {
            Entity curEnt = it.next();
            curEnt.update();
            if(curEnt instanceof Deletable && ((Deletable) curEnt).isDelete())
                it.remove();
        }
        
        if (kb.isDown("ESCAPE")) {
            screens.pop();
            ((Menu) screens.peek()).resetMenu();
        } else if (kb.isDown("R"))
            restart();
        
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
