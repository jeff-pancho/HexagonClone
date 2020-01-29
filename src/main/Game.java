package main;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    
    Scene scene;
    Group root;
    Canvas canvas;
    GraphicsContext gc;
    ArrayList<Entity> entityList;
    
    private void initStage(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setTitle("HexagonClone");
        
        stage.setMaxWidth(WIDTH);
        stage.setMinWidth(WIDTH);
        stage.setMaxHeight(HEIGHT);
        stage.setMinHeight(HEIGHT);
        
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        canvas = new Canvas(WIDTH, HEIGHT);
        root = new Group(canvas);
        scene = new Scene(root, WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();
        
        gc.setFill(Color.BLACK);
        
        
        
        entityList = new ArrayList<Entity>();
        
        for(int i = 0; i < 5; i++) {
            entityList.add(new Side(i, 20));
        }
        
        initStage(stage, scene);
        
        AnimationTimer animator = new AnimationTimer() {
            int counter = 0;
            
            public void handle(long arg0) {
                if (counter++ >= 45) {
                    for(int i = 0; i < 5; i++) {
                        entityList.add(new Side(i, 20));
                    }
                    counter = 0;
                }
                
                
                update();
                render(gc);
            }
        };
        
        animator.start();
    }
    
    private void update() {
        for(Entity e : entityList)
            e.update();
    }
    
    private void render(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        for(Entity e : entityList)
            e.render(gc);
    }
    
    public static void prt(double[] a) {
        for(double d : a)
            System.out.print(d + " ");
        System.out.println();
    }
    
    public void run() {
        launch();
    }
}
