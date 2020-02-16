package main.game.entity;

import javafx.scene.canvas.GraphicsContext;
import main.Game;

/**
 * A Polygon Entity with several xPoints and yPoints.
 * @author Jeff
 */
public abstract class Polygon extends Entity {
    protected double[] xPoints;
    protected double[] yPoints;
    
    /**
     * Create a polygon with the inputted number of points.
     * @param gc
     * @param numPoints
     */
    public Polygon(GraphicsContext gc, int numPoints) {
        super(gc);
        this.xPoints = new double[numPoints];
        this.yPoints = new double[numPoints];
    }
    
    /**
     * Return the Polygon's xPoints.
     * @return xPoints
     */
    public double[] getXPoints() {
        return this.xPoints;
    }
    
    /**
     * Return the Polygon's yPoints.
     * @return yPoints
     */
    public double[] getYPoints() {
        return this.yPoints;
    }
    
    /**
     * Return the number of points or sides the Polygon has
     * @return number of points
     */
    public int getNumPoints() {
        return this.xPoints.length;
    }
    
    /**
     * Generate x and y points of a Polygon.
     * @param centerX
     * @param centerY
     * @param xPt
     * @param yPt
     * @param dir
     * @param radius
     */
    public static void generatePolygon(double centerX, double centerY
            , double[] xPt, double[] yPt, double dir, double radius ) {
        
        double pointDir;
        for(int i = 0; i < xPt.length; i ++) {
            pointDir = dir + (Math.PI * 2 / xPt.length * i);
            xPt[i] = centerX + (Math.cos(pointDir) * radius);
            yPt[i] = centerY + (Math.sin(pointDir) * radius);
        }
        
    }
    
    /**
     * Generate x and y points of a Wall.
     * @param xPt
     * @param yPt
     * @param dir
     * @param dist
     * @param size
     */
    public static void generateWall(double xPt[], double yPt[]
            , double dir, double dist, double size) {
        
        double pointDir;
        double pointDist;
        
        for(int i = 0; i < xPt.length; i++) {
            pointDir = i >= 2 ?
                    dir + (Math.PI / 3)
                    : dir;
            pointDist = i == 1 || i == 2 ?
                    dist + size
                    : dist;
            xPt[i] = Game.CENTER_X
                    + (Math.cos(pointDir) * pointDist);
            yPt[i] = Game.CENTER_Y
                    + (Math.sin(pointDir) * pointDist);
        }
    }
    
}
