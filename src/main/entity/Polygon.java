package main.entity;

import javafx.scene.canvas.GraphicsContext;
import main.Entity;
import main.Game;

public abstract class Polygon extends Entity {
    protected double[] xPoints;
    protected double[] yPoints;
    protected double dir;
    
    public Polygon(int xPointsLen, int yPointsLen) {
        this.xPoints = new double[xPointsLen];
        this.yPoints = new double[yPointsLen];
    }
    
    public double[] getXPoints() {
        return this.xPoints;
    }
    
    public double[] getYPoints() {
        return this.yPoints;
    }
    
    public int getSides() {
        return this.xPoints.length;
    }
    
    public double getDir() {
        return this.dir;
    }
    
    public void render(GraphicsContext gc) {
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
    }
    
    public static void generatePolygon(double centerX, double centerY
            , double[] xPt, double[] yPt, double dir, double radius ) {
        double pointDir;
        for(int i = 0; i < xPt.length; i ++) {
            pointDir = dir + (Math.PI * 2 / 3 * i);
            xPt[i] = centerX + (Math.cos(pointDir) * radius);
            yPt[i] = centerY + (Math.sin(pointDir) * radius);
        }
    }
    
    public static void generateSide(double xPt[], double yPt[]
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
            xPt[i] = (Game.WIDTH / 2) 
                    + (Math.cos(pointDir) * pointDist);
            yPt[i] = (Game.HEIGHT / 2) 
                    + (Math.sin(pointDir) * pointDist);
        }
    }
}
