package main.ui;

import javafx.scene.paint.Color;

/**
 * Palette for colouring Polygons.
 * @author Jeff
 */
public class Palette {
    private Color strokeClr;
    private Color fillClr;
    
    public Palette(Color strokeClr, Color fillClr) {
        this.strokeClr = strokeClr;
        this.fillClr = fillClr;
    }

    public Color getStrokeClr() {
        return strokeClr;
    }

    public void setStrokeClr(Color strokeClr) {
        this.strokeClr = strokeClr;
    }

    public Color getFillClr() {
        return fillClr;
    }

    public void setFillClr(Color fillClr) {
        this.fillClr = fillClr;
    }
}
