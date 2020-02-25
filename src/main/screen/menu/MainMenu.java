/**
 * 
 */
package main.screen.menu;

import java.util.Stack;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import main.game.entity.BackgroundPoly;
import main.game.entity.CenterHexagon;
import main.game.entity.Entity;
import main.input.Keyboard;
import main.screen.Screen;
import main.ui.Palette;
import main.ui.UI;
import main.ui.button.Button;
import main.ui.button.main_menu.PlayButton;
import main.ui.button.main_menu.QuitButton;
import main.ui.title.main_menu.MainTitle;

/**
 * The main menu that first appears when the game is started.
 * @author Jeff
 */
public class MainMenu extends Menu {
    private final Button play, quit;
    
    private Palette bgPalette1;
    private Palette bgPalette2;
    
    /**
     * Create new buttons to add to the menu.
     * @param gc
     * @param kb
     * @param screens
     */
    public MainMenu(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        
        bgPalette1 = new Palette(Color.BLACK, Color.PINK);
        bgPalette2 = new Palette(Color.BLACK, Color.WHITE);
        
        
        play = new PlayButton(gc, menuDir);
        quit = new QuitButton(gc, menuDir);
        
        curButton = play;
        curButton.setSwitching(true);

        addButton(play);
        addButton(quit);
        
        uiElements.add(new MainTitle(gc));
        
        for(int i = 0; i < 6; i++) {
            Palette p = i % 2 == 0 ? bgPalette1 : bgPalette2;
            entities.add(new BackgroundPoly(gc, Game.CENTER_X, Game.HEIGHT + 100, menuDir, p, i));
        }
        
        entities.add(new CenterHexagon(gc, Game.CENTER_X, Game.HEIGHT + 100, 200, menuDir, bgPalette2));
        
//        setButtonDir();
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
        menuDir[0] -= (menuDir[0] - targetDir) / easeFactor;
        setButtonDir();
        
        for (Entity curEnt : entities)
            curEnt.update();
        
        for (UI curUI : uiElements)
            curUI.update();
    }
    
}
