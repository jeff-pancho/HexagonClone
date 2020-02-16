/**
 * 
 */
package main.screen.menu;

import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import main.input.Keyboard;
import main.screen.GameScreen;
import main.screen.Screen;
import main.ui.UI;
import main.ui.button.Button;
import main.ui.button.level_menu.EasyButton;
import main.ui.button.level_menu.HardButton;
import main.ui.button.level_menu.MediumButton;

/**
 * The level menu that appears when the user presses play on the
 * main menu.
 * @author Jeff
 */
public class LevelMenu extends Menu {
    private final Button easy, medium, hard;
    
    /**
     * Create new buttons to add to the menu.
     * @param gc
     * @param kb
     * @param screens
     */
    public LevelMenu(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        
        easy = new EasyButton(gc);
        medium = new MediumButton(gc);
        hard = new HardButton(gc);
        
        curButton = easy;
        curButton.setSwitching(true);

        buttons.add(easy);
        buttons.add(medium);
        buttons.add(hard);

        uiElements.add(easy);
        uiElements.add(medium);
        uiElements.add(hard);
//        uiElements.add(new MainTitle(gc));
        
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
            else if (kb.isDown("ENTER")) {
                curInd = 0;
                curButton = buttons.get(curInd);
                screens.push(new GameScreen(gc, kb, screens));
            } else if (kb.isDown("ESCAPE")) {
                screens.pop();
                ((Menu) screens.peek()).resetMenu();
            }
        }
        
        // Turn dir towards targetDir
        dir -= (dir - targetDir) / 5;
        setButtonDir();
        
        for (UI curUI : uiElements)
            curUI.update();
    }
    
}
