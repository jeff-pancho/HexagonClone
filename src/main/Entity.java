package main;

import javafx.scene.canvas.GraphicsContext;

public abstract class Entity {
    public abstract void update();
    public abstract void render(GraphicsContext gc);
}
