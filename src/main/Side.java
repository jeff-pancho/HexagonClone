package main;

import javafx.scene.shape.Polygon;

public class Side extends Polygon {
    private Double[] coords;
    private double size;
    private double dist;
    private int side;
    
    Side(int side, double size) {
        super();
        this.dist = 600;
        this.size = size;
        this.side = side;
        
        this.coords = new Double[] {
            0d, 0d,
            0d, 0d,
            0d, 0d,
            400d, 300d
        };
    }
    
    public void update(double dir) {
        double xCenter = 400;
        double yCenter = 300;
//        dist = Math.abs(Math.sin(dir * 2) * 300);
//        dist = Math.sin(dir * 2) * 300;
        dist -= 3;
        
        double pointDir;
        double pointDist;
        
        getPoints().removeAll(coords);
        for(int i = 0; i < coords.length; i += 2) {
            pointDir = i >= 4 ? dir + (Math.PI / 3) : dir;
            pointDist = i == 2 || i == 4 ? dist + size : dist;
            coords[i] = xCenter + (Math.cos(pointDir) * pointDist);
            coords[i + 1] = yCenter + (Math.sin(pointDir) * pointDist);
        }
        
        getPoints().addAll(coords);
        
//        changePoints(coords);
    }
    
//    private void changePoints(Double[] coords) {
//        getPoints().removeAll(coords);
//        getPoints().addAll(coords);
//    }
}
