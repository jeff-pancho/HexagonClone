/**
 * 
 */
package main.screen.menu;

import java.util.Stack;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import main.input.Keyboard;
import main.screen.Screen;
import main.ui.UI;
import main.ui.button.Button;
import main.ui.button.main_menu.PlayButton;
import main.ui.button.main_menu.QuitButton;

/**
 * The main menu that first appears when the game is started.
 * @author Jeff
 */
public class MainMenu extends Menu {
    private final Button play, quit;
    
    /**
     * Create new buttons to add to the menu.
     * @param gc
     * @param kb
     * @param screens
     */
    public MainMenu(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        
        play = new PlayButton(gc);
        quit = new QuitButton(gc);
        
        curButton = play;
        curButton.setSwitching(true);

        buttons.add(play);
        buttons.add(quit);

        uiElements.add(play);
        uiElements.add(quit);
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
            else if (kb.isDown("ENTER"))
                if(curButton == play) {
                    curInd = 0;
                    curButton = buttons.get(curInd);
                    screens.push(new LevelMenu(gc, kb, screens));
                } else
                    Platform.exit();
        }
        
        // Turn dir towards targetDir
        dir -= (dir - targetDir) / 5;
        setButtonDir();
        
        for (UI curUI : uiElements)
            curUI.update();
    }
    
}
