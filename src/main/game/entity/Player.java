package main.game.entity;

import javafx.scene.canvas.GraphicsContext;
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
     */
    public Player(GraphicsContext gc, Keyboard kb) {
        // The player is a triangle, therefore 3 points are inputted.
        super(gc, 3);
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
        
        // Update the Player's xPoints and yPoints
        double xPos = Game.CENTER_X + Math.cos(dir) * dist;
        double yPos = Game.CENTER_Y + Math.sin(dir) * dist;
        Polygon.generatePolygon(xPos, yPos, xPoints, yPoints, dir, radius);
    }
    
    /**
     * Render the player as a filled Polygon.
     */
    @Override
    public void render() {
        render(true);
    }

}
