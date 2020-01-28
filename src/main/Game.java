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
    
    private void initStage(Stage stage) {
        stage.setScene(scene);
        stage.setTitle("HexagonClone");
        
        stage.setMaxWidth(800);
        stage.setMinWidth(800);
        stage.setMaxHeight(600);
        stage.setMinHeight(600);
        
        stage.resizableProperty().setValue(false);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
//        Side s1 = new Side(0, 25);
        
//        root = new Group(s1);
        root = new Group();
        scene = new Scene(root, 800, 600);
        
        Side[] sides = new Side[6];
        for(int i = 0; i < sides.length; i++) {
            sides[i] = new Side(1, 25);
            root.getChildren().add(sides[i]);
        }
        initStage(stage);
        stage.show();
        
        AnimationTimer animator = new AnimationTimer() {
            double dir = 0;
            
            public void handle(long arg0) {
                dir += Math.PI / 100;
                for(int i = 0; i < sides.length; i++)
                    sides[i].update(dir +((Math.PI / 3) * i));
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
