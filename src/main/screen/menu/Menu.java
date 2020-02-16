package main.screen.menu;

import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.input.Keyboard;
import main.screen.Screen;
import main.ui.UI;
import main.ui.button.Button;

/**
 * A menu with orbiting buttons.
 * @author Jeff
 */
public abstract class Menu extends Screen {
    protected final ArrayList<UI> uiElements;
    protected final ArrayList<Button> buttons;
    
    protected int curInd;
    protected Button curButton;
    
    protected double dir;
    protected double targetDir;

    public Menu(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        uiElements = new ArrayList<>();
        buttons = new ArrayList<>();
        
        resetMenu();
    }

    /**
     * Render the menu and its contents using its GraphicsContext.
     */
    @Override
    public void render() {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);

        for (UI curUI : uiElements)
            curUI.render();
    }
    
    /**
     * Resets the Menu.
     */
    public void resetMenu() {
        if(curButton != null)
            curButton.setSwitching(true);
        
        // Direction towards the west
        dir = Math.PI;
//        dir = 3 * Math.PI / 2;
        targetDir = 3 * Math.PI / 2;
    }
    
    /**
     * Change selected Button to the one that is i positions more than 
     * the current Button.
     * @param i
     */
    protected void changeButton(int i) {
        /*
         * Change the index to get the new button.
         * It can wrap back around the possible indices for the
         * ArrayList.
         */
        curInd += i;
        curInd %= buttons.size();
        if (curInd < 0)
            curInd += buttons.size();
        
        curButton = buttons.get(curInd);
        curButton.setSwitching(true);
        
        // Change the direction so it can rotate the selected button
        final double fullRot = 2 * Math.PI;
        targetDir -= fullRot / buttons.size() * i;
    }
    
    /**
     * Sets the direction of each button in the Menu.
     */
    protected void setButtonDir() {
        for(int i = 0; i < buttons.size(); i++) {
            Button b = buttons.get(i);
            final double fullRot = 2 * Math.PI;
            b.setDir(dir + fullRot / buttons.size() * i);
        }
    }

}
