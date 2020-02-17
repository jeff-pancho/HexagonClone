package main.game.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;

/**
 * A Polygon that makes up the background.
 * @author Jeff
 */
public class BackgroundPoly extends Polygon {
    private int side;
    private final double centerX;
    private final double centerY;
    
    /**
     * Initialize the BackgroundPoly.
     * @param gc
     * @param centerX
     * @param centerY
     * @param gameDir
     * @param side
     */
    public BackgroundPoly(GraphicsContext gc, double centerX, double centerY, double[] gameDir, int side) {
        super(gc, 3, gameDir);
        this.centerX = centerX;
        this.centerY = centerY;
        this.side = side;
        this.dir = Math.PI / 3 * side;
    }
    
    /**
     * Generate the points of the BackgroundPoly.
     */
    @Override
    public void update() {
        double pointDir;
        double pointDist;
        for(int i = 0; i < xPoints.length; i++) {
            pointDir = gameDir[0] + (i < 2 ?
                    dir
                    : dir + (Math.PI / 3));
            pointDist = i > 0 ?
                    2000
                    : 0;
            xPoints[i] = centerX + (Math.cos(pointDir) * pointDist);
            yPoints[i] = centerY + (Math.sin(pointDir) * pointDist);
        }
    }
    
    /**
     * Render the BackgroundPoly using the GraphicsContext.
     */
    @Override
    public void render() {
        gc.setFill(side % 2 == 0 ? Color.PINK : Color.WHITE);
        render(true);
    }
}
