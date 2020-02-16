package main;

import java.util.Stack;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import main.input.Keyboard;
import main.screen.MainMenu;
import main.screen.Screen;

/**
 * The game.
 * @author Jeff
 */
public class Game extends Application {
    /** Width of the window. */
    public static final int WIDTH = 1024;
    /** Height of the window. */
    public static final int HEIGHT = 768;
    /** Horizontal center of the window. */
    public static final int CENTER_X = WIDTH / 2;
    /** Vertical center of the window. */
    public static final int CENTER_Y = HEIGHT / 2;
    
    private Keyboard kb;
    private Canvas canvas;
    private GraphicsContext gc;
    private Group root;
    private Scene scene;
    private Stack<Screen> screens;
    
    /**
     * Initialize Game.
     */
    public Game() {
        kb = new Keyboard();
        screens = new Stack<>();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Group root = new Group(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        // Push the main menu to the stack.
        screens.push(new MainMenu(gc, kb, screens));
        
        // Input handling
        scene.setOnKeyPressed(kb::captureInput);
        scene.setOnKeyReleased(kb::releaseInput);
        initStage(stage, scene);
        
        AnimationTimer timer = new AnimationTimer() {
            
            /**
             * Main game loop.
             */
            public void handle(long now) {
                // Update and render the screen at the top of the stack.
                if (screens.size() > 0) {
                    Screen curScreen = screens.peek();
                    curScreen.update();
                    curScreen.render();
                }
                
            }
            
        };
        
        timer.start();
        stage.show();
    }
    
    /**
     * Initialize stage settings.
     * @param stage
     */
    private void initStage(Stage stage, Scene scene) {
        stage.setMaxWidth(WIDTH);
        stage.setMaxHeight(HEIGHT);
        stage.setMinWidth(WIDTH);
        stage.setMinHeight(HEIGHT);
        stage.resizableProperty().setValue(false);

        stage.setTitle("HexagonClone");
        stage.setScene(scene);
    }
    
    /**
     * Launch the JavaFX application.
     */
    public void run() {
        launch();
    }
    
}
