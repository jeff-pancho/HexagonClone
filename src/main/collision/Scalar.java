package main.collision;

import javafx.geometry.Point2D;
import main.entity.Polygon;
import main.collision.Scalar;

public class Scalar {
    private double min;
    private double max;
    
    public Scalar(double min, double max) {
        this.min = min;
        this.max = max;
    }
    
    public boolean ifOverlap(Scalar s) {
        return min < s.max && max > s.min;
    }
    
    public boolean ifOverlap(double min, double max) {
        return this.min < max && this.max > min;
    }
    
    public static Scalar project(Polygon p, Point2D axis) {
        double dotProducts[] = new double[p.getSides()];
        for(int i = 0; i < p.getSides(); i++) {
            Point2D point = new Point2D(p.getXPoints()[i], p.getYPoints()[i]);
            dotProducts[i] = point.dotProduct(axis);
        }
        return new Scalar(min(dotProducts), max(dotProducts));
    }
    
    private static double min(double[] nums) {
        double min = nums[0];
        for(int i = 1; i < nums.length; i++)
            if(nums[i] < min)
                min = nums[i];
        return min;
    }
    
    private static double max(double[] nums) {
        double max = nums[0];
        for(int i = 1; i < nums.length; i++)
            if(nums[i] > max)
                max = nums[i];
        return max;
    }
}
