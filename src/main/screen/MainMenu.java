/**
 * 
 */
package main.screen;

import java.util.ArrayList;
import java.util.Stack;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.input.Keyboard;
import main.ui.UI;
import main.ui.button.Button;
import main.ui.button.main_menu.PlayButton;
import main.ui.button.main_menu.QuitButton;

/**
 * The main menu.
 * @author Jeff
 */
public class MainMenu extends Screen {
    private final ArrayList<UI> uiElements;
    private final ArrayList<Button> buttons;
    
    private int curInd;
    private Button curButton;
    private final Button play, quit;
    
    private double dir;
    private double targetDir;

    public MainMenu(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        uiElements = new ArrayList<>();
        buttons = new ArrayList<>();
        
        play = new PlayButton(gc);
        quit = new QuitButton(gc);
        
        curButton = play;
        curButton.setSwitching(true);

        buttons.add(play);
        buttons.add(quit);

        uiElements.add(play);
        uiElements.add(quit);
//        uiElements.add(new MainTitle(gc));
        
        // Direction towards the north
        dir = 3 * Math.PI / 2;
        targetDir = dir;
        
        setButtonDir();
    }
    
    /**
     * Update the main menu and its contents
     */
    @Override
    public void update() {
        // Keyboard input handling while no buttons are switching
        if (!curButton.isSwitching()) {
            if (kb.isDown("LEFT"))
                changeButton(-1);
            else if (kb.isDown("RIGHT"))
                changeButton(1);
            else if (kb.isDown("ENTER"))
                if(curButton == play);
                else
                    Platform.exit();
        }
        
        // Turn dir towards targetDir
        dir -= (dir - targetDir) / 5;
        setButtonDir();
        
        for (UI curUI : uiElements)
            curUI.update();
    }
    
    /**
     * Render the main menu and its contents using its GraphicsContext.
     */
    @Override
    public void render() {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);

        for (UI curUI : uiElements)
            curUI.render();
    }
    
    /**
     * Change selected Button to the one that is i positions more than 
     * the current Button.
     * @param i
     */
    private void changeButton(int i) {
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
    private void setButtonDir() {
        for(int i = 0; i < buttons.size(); i++) {
            Button b = buttons.get(i);
            final double fullRot = 2 * Math.PI;
            b.setDir(dir + fullRot / buttons.size() * i);
        }
    }

}
