package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.shape.Polygon;

public class Game extends Application {
    
    Scene scene;
    Group root;
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Double[] coords = {
          300.0, 50.0,
          350.0, 50.0,
          350.0, 100.0,
          300.0, 100.0
        };
        
        Polygon poly = new Polygon();
        poly.getPoints().addAll(coords);
        
        root = new Group(poly);
        scene = new Scene(root, 800, 600);
        
        stage.setScene(scene);
        stage.setTitle("HexagonClone");
        stage.show();
        
        AnimationTimer animator = new AnimationTimer() {
            public void handle(long arg0) {
                poly.getPoints().removeAll(coords);
                for(int i = 0; i < coords.length; i++) {
                    coords[i] += 3;
                }
                poly.getPoints().addAll(coords);
                
            }
        };
        
        animator.start();
    }
    
    public void prt(Double[] a) {
        for(double d : a)
            System.out.print(d + " ");
        System.out.println();
    }
    
    public void run() {
        launch();
    }
}
