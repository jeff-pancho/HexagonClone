package main;

import javafx.scene.canvas.GraphicsContext;

public class Player extends Entity implements Deletable {
    private double[] xPoints;
    private double[] yPoints;
    private double dir;
    private final double dist;
    private final double radius;
    
    Player() {
        this.xPoints = new double[3];
        this.yPoints = new double[3];
        this.dir = 0;
        this.dist = 80;
        this.radius = 10;
    }

    void update() {
        if(Game.rightDown)
            dir += Math.PI / 25;
        else if (Game.leftDown)
            dir -= Math.PI / 25;
        
        double xPos = (Game.WIDTH / 2) + (Math.cos(dir + Game.dir) * dist);
        double yPos = (Game.HEIGHT / 2) + (Math.sin(dir + Game.dir) * dist);
        for(int i = 0; i < 3; i ++) {
            xPoints[i] = xPos + (Math.cos(dir + Game.dir 
                    + (Math.PI * 2 / 3 * i)) * radius);
            yPoints[i] = yPos + (Math.sin(dir + Game.dir 
                    + (Math.PI * 2 / 3 * i)) * radius);
        }
    }

    void render(GraphicsContext gc) {
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
    }
    
    public boolean ifDelete() {
        return false;
    }
}
