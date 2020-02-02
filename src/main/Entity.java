package main;

import javafx.scene.canvas.GraphicsContext;

public abstract class Entity {
    abstract void update();
    abstract void render(GraphicsContext gc);
}
