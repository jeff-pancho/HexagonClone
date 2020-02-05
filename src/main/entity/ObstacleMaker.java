package main.entity;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;

public class ObstacleMaker {
    int counter;
    ArrayList<Entity> entityList;
    Random rd;
    
    public ObstacleMaker(ArrayList<Entity> entityList) {
        this.entityList = entityList;
        this.counter = 0;
        this.rd = new Random();
    }
    
    public void update() {
        if(counter++ >= 40) {
            int randSide = rd.nextInt(6);
            createOpenHexagon(randSide);
        }
    }
    
    private void createOpenHexagon(int side) {
        for(int i = 0; i < 5; i++) {
            entityList.add(6, new Side((side + i) % 6, 20
                    , Color.BLACK));
        }
        counter = 0;
    }
}
