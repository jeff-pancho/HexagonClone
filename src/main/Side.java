package main;

import javafx.scene.canvas.GraphicsContext;

public class Side extends Entity {
    private double[] xPoints;
    private double[] yPoints;
    private double size;
    private double dist;
    private double dir;
    private int side;
    
    Side(int side, double size) {
        // starting distance should always be beyond the screen
        this.dist = 500;
        this.size = size;
        this.side = side;
        this.xPoints = new double[] {
                0d, 0d, 0d, 0d
        };
        this.yPoints = new double[] {
                0d, 0d, 0d, 0d
        };
        this.dir = Math.PI / 3 * side;
    }
    
    public void update() {
        double pointDir;
        double pointDist;
        dir += Math.PI / 100;
        dist -= 3;
        
        for(int i = 0; i < xPoints.length; i++) {
            pointDir = i >= 2 ?
                    dir + (Math.PI / 3)
                    : dir;
            pointDist = i == 1 || i == 2 ?
                    dist + size
                    : dist;
            xPoints[i] = (Game.WIDTH / 2) + (Math.cos(pointDir) * pointDist);
            yPoints[i] = (Game.HEIGHT / 2) + (Math.sin(pointDir) * pointDist);
        }
    }
    
    public void render(GraphicsContext gc) {
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
    }
    
    public double[] getXPoints() {
        return this.xPoints;
    }
    
    public double[] getYPoints() {
        return this.yPoints;
    }
}
