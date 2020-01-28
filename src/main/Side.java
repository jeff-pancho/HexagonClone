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
    
    /*
     * xCenter + Math.cos(dir) * dist
     * yCenter + Math.sin(dir) * dist
     * xCenter + Math.cos(dir) * (dist + size)
     * yCenter + Math.sin(dir) * (dist + size)
     * xCenter + Math.cos(dir + (Math.PI / 3)) * (dist + size)
     * yCenter + Math.sin(dir + (Math.PI / 3)) * (dist + size)
     * xCenter + Math.cos(dir + (Math.PI / 3)) * dist
     * yCenter + Math.sin(dir + (Math.PI / 3)) * dist
     */
    
    public void update(double dir) {
        double xCenter = 400;
        double yCenter = 300;
        dist = Math.abs(Math.sin(dir) * 300);
        
        getPoints().removeAll(coords);
//        for(int i = 0; i < coords.length; i++) {
//            
//        }
        coords[0] = xCenter + (Math.cos(dir) * dist);
        coords[1] = yCenter + (Math.sin(dir) * dist);
        coords[2] = xCenter + (Math.cos(dir) * (dist + size));
        coords[3] = yCenter + (Math.sin(dir) * (dist + size));
        coords[4] = xCenter + (Math.cos(dir + 1) * (dist + size));
        coords[5] = yCenter + (Math.sin(dir + 1) * (dist + size));
        coords[6] = xCenter + (Math.cos(dir + 1) * dist);
        coords[7] = yCenter + (Math.sin(dir + 1) * dist);
        
        getPoints().addAll(coords);
        
//        changePoints(coords);
    }
    
//    private void changePoints(Double[] coords) {
//        getPoints().removeAll(coords);
//        getPoints().addAll(coords);
//    }
}
