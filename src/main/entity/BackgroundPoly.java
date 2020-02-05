package main.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;

public class BackgroundPoly extends Polygon {
    Color color;
    double side;

    public BackgroundPoly(Color color, int side) {
        super(3);
        this.color = color;
        this.dir = (Math.PI / 3 * side);
    }

    public void update() {
        double pointDir;
        double pointDist;
        for(int i = 0; i < xPoints.length; i++) {
            pointDir = Game.dir + (i < 2 ?
                    dir
                    : dir + (Math.PI / 3));
            pointDist = i > 0 ?
                    1000
                    : 0;
            xPoints[i] = Game.CENTER_X + (Math.cos(pointDir) * pointDist);
            yPoints[i] = Game.CENTER_Y + (Math.sin(pointDir) * pointDist);
        }
    }
    
    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
    }

}
