/**
 * 
 */
package main.screen.menu;

import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import main.game.entity.BackgroundPoly;
import main.game.entity.CenterHexagon;
import main.game.entity.Entity;
import main.input.Keyboard;
import main.screen.GameScreen;
import main.screen.Screen;
import main.ui.Palette;
import main.ui.UI;
import main.ui.button.Button;
import main.ui.button.level_menu.EasyButton;
import main.ui.button.level_menu.HardButton;
import main.ui.button.level_menu.MediumButton;
import main.ui.title.level_menu.LevelTitle;

/**
 * The level menu that appears when the user presses play on the
 * main menu.
 * @author Jeff
 */
public class LevelMenu extends Menu {
    private final Button easy, medium, hard;
    
    
    
    private Palette bgPalette1;
    private Palette bgPalette2;
    
    /**
     * Create new buttons to add to the menu.
     * @param gc
     * @param kb
     * @param screens
     */
    public LevelMenu(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        
        bgPalette1 = new Palette(Color.BLACK, Color.PINK);
        bgPalette2 = new Palette(Color.BLACK, Color.WHITE);
        
        easy = new EasyButton(gc, menuDir);
        medium = new MediumButton(gc, menuDir);
        hard = new HardButton(gc, menuDir);
        
        curButton = easy;
        curButton.setSwitching(true);

        addButton(easy);
        addButton(medium);
        addButton(hard);

        uiElements.add(new LevelTitle(gc));
        
        for(int i = 0; i < 6; i++) {
            Palette p = i % 2 == 0 ? bgPalette1 : bgPalette2;
            entities.add(new BackgroundPoly(gc, Game.CENTER_X, Game.HEIGHT + 100, menuDir, p, i));
        }
        
        entities.add(new CenterHexagon(gc, Game.CENTER_X, Game.HEIGHT + 100, 200, menuDir, bgPalette2));
        
        setButtonDir();
    }
    
    /**
     * Update the main menu and its contents
     */
    @Override
    public void update() {
        // Keyboard input handling while no buttons are switching
        if (!curButton.isSwitching()) {
            if (kb.isDown("LEFT")) {
                changeButton(-1);
                changePalette();
            }
            else if (kb.isDown("RIGHT")) {
                changeButton(1);
                changePalette();
            }
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
        menuDir[0] -= (menuDir[0] - targetDir) / easeFactor;
        setButtonDir();
        
        for (Entity curEnt : entities)
            curEnt.update();
        
        for (UI curUI : uiElements)
            curUI.update();
    }
    
    // TODO: FIX THIS GARBAGE
    /**
     * Change the Palettes depending on the selected button.
     * 
     */
    private void changePalette() {
        switch(curInd) {
        case 0:
            bgPalette1.setFillClr(Color.PINK);
            break;
        case 1:
            bgPalette1.setFillClr(Color.GREEN);
            break;
        case 2:
            bgPalette1.setFillClr(Color.RED);
            break;
        }
    }
    
}
