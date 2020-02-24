package main.game.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Wall obstacle in the Game.
 * @author Jeff
 */
public class Wall extends Polygon implements Deletable {
    private double size;
    private double dist;

    public Wall(GraphicsContext gc, double[] gameDir, int side, double dist, double size) {
        super(gc, 4, gameDir);
        this.dist = dist;
        this.size = size;
        this.dir = (Math.PI / 3) * side;
    }

    @Override
    public void update() {
        dist -= 6;
        Polygon.generateWall(xPoints, yPoints, gameDir[0] + dir, dist, size);
    }

    @Override
    public void render() {
        gc.setFill(Color.BLACK);
        render(true);
    }
    
    /**
     * Checks if the Wall is able to be deleted. It will be able to be
     * deleted when its under a certain distance from the center.
     * @boolean if the Wall is able to be deleted.
     */
    @Override
    public boolean isDelete() {
        return dist <= 10;
    }
    
    /**
     * Return dist.
     * @return dist
     */
    public double getDist() {
        return this.dist;
    }

}
