package main.input;

import java.util.ArrayList;

import javafx.scene.input.KeyEvent;

/**
 * Holds all the current keys held
 * @author Jeff
 */
public class Keyboard {
    private ArrayList<String> inputs;

    public Keyboard() {
        inputs = new ArrayList<>();
    }
    
    /**
     * Captures the input and stores it into an ArrayList as a string.
     * @param e
     */
    public void captureInput(KeyEvent e) {
        String inputCode = e.getCode().toString();
        if (!inputs.contains(inputCode))
            inputs.add(inputCode);
    }
    
    /**
     * Removes the released key from the ArrayList.
     * @param e
     */
    public void releaseInput(KeyEvent e) {
        String inputCode = e.getCode().toString();
        inputs.remove(inputCode);
    }
    
    /**
     * Checks if the inputted key is down.
     * @param code
     * @return if key is down
     */
    public boolean isDown(String code) {
        return inputs.contains(code);
    }
}
