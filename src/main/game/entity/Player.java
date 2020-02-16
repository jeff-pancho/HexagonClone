package main.game.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import main.input.Keyboard;

/**
 * The Player in the game.
 * @author Jeff
 */
public class Player extends Polygon {
    /** Player's distance from the center. */
    private final double dist;
    private final double radius;
    
    private Keyboard kb;
    
    /**
     * Initialize the Player, assigning it references to the game's
     * GraphicsContext and keyboard.
     * @param gc
     * @param kb
     * @param gameDir
     */
    public Player(GraphicsContext gc, Keyboard kb, double[] gameDir) {
        // The player is a triangle, therefore 3 points are inputted.
        super(gc, 3, gameDir);
        this.kb = kb;
        
        this.dir = 0;
        this.dist = 80;
        this.radius = 10;
    }
    
    /**
     * Update the Player.
     */
    @Override
    public void update() {
        final double dirChange = Math.PI / 25;
        final double fullRot = 2 * Math.PI;
        
        if (kb.isDown("LEFT"))
            dir -= dirChange;
        else if (kb.isDown("RIGHT"))
            dir += dirChange;
        
        // Make direction wrap around [0, 2PI]
        dir %= fullRot; 
        if (dir < 0)
            dir += fullRot;
        
        // the only way to pass by reference : )
        final double offsetDir = dir + gameDir[0];
        
        // Update the Player's xPoints and yPoints
        double xPos = Game.CENTER_X + Math.cos(offsetDir) * dist;
        double yPos = Game.CENTER_Y + Math.sin(offsetDir) * dist;
        Polygon.generatePolygon(xPos, yPos, xPoints, yPoints, offsetDir, radius);
    }
    
    /**
     * Render the player as a filled Polygon.
     */
    @Override
    public void render() {
        gc.setFill(Color.BLACK);
        render(true);
    }

}
