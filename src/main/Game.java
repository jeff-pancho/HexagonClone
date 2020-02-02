package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    
    public static double dir = 0;
    
    Scene scene;
    Group root;
    Canvas canvas;
    GraphicsContext gc;
    ArrayList<Entity> entityList;
    Iterator<Entity> it;
    Random rd;
    
    
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
        rd = new Random();
        
        gc.setFill(Color.BLACK);
        
        entityList = new ArrayList<Entity>();
        entityList.add(new Player());
        
        initStage(stage, scene);
        
        AnimationTimer animator = new AnimationTimer() {
            int counter = 0;
            
            public void handle(long arg0) {
                if (counter++ >= 30) {
                    int offset = rd.nextInt(6);
                    for(int i = 0; i < 5; i++) {
                        entityList.add(new Side((i + offset) % 6, 20));
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
        it = entityList.iterator();
        dir += Math.PI / 100;
        while(it.hasNext()) {
            Entity ent = it.next();
            ent.update();
            if(ent instanceof Deletable && ((Deletable) ent).ifDelete())
                it.remove();
        }
    }
    
    private void render(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        for(Entity e : entityList)
            e.render(gc);
    }
    
    public void run() {
        launch();
    }
}
