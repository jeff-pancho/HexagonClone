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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.entity.CenterHexagon;
import main.entity.Player;
import main.entity.Side;

public class Game extends Application {
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    
    public static double dir = 0;
    public static boolean leftDown = false;
    public static boolean rightDown = false;
    
    private Scene scene;
    private Group root;
    private Canvas canvas;
    private GraphicsContext gc;
    private ArrayList<Entity> entityList;
    private Iterator<Entity> it;
    private Random rd;
    
    
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
        
        scene.setOnKeyPressed(this::handleKeyPress);
        scene.setOnKeyReleased(this::handleKeyRelease);
        
        gc.setFill(Color.BLACK);
        
        entityList = new ArrayList<Entity>();
        entityList.add(new Player());
        entityList.add(new CenterHexagon());
        
        initStage(stage, scene);
        
        AnimationTimer animator = new AnimationTimer() {
            int counter = 0;
            
            public void handle(long arg0) {
                if (counter++ >= 40) {
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
    
    private void handleKeyPress(KeyEvent e) {
        switch(e.getCode()) {
        case RIGHT:
            rightDown = true;
            break;
        case LEFT:
            leftDown = true;
            break;
        default:
            break;
        }
    }
    
    private void handleKeyRelease(KeyEvent e) {
        switch(e.getCode()) {
        case RIGHT:
            rightDown = false;
            break;
        case LEFT:
            leftDown = false;
            break;
        default:
            break;
        }
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
