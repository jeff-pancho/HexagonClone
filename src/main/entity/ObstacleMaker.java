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
        System.out.println(counter);
        if(counter++ >= 45) {
            
            int randSide = rd.nextInt(6);
            switch(rd.nextInt(3)) {
            case 0:
                createOpenHexagon(randSide);
                break;
            case 1:
                createWalls(randSide);
                break;
            case 2:
                createWhirlwind(randSide);
                break;
            }
        }
    }
    
    
    //TODO: THINK UP OF BETTER NAMES
    private void createOpenHexagon(int offsetSide) {
        for(int i = 0; i < 5; i++) {
            Side side = new Side((offsetSide + i) % 6, 800
                    , 20, Color.BLACK);
            entityList.add(6, side);
        }
        counter = 0;
    }
    
    private void createWalls(int offsetSide) {
        for(int i = 0; i < 3; i++) {
            Side side = new Side((offsetSide + i * 2) % 6, 800
                    , 20, Color.BLACK);
            entityList.add(6, side);
        }
        counter = 0;
    }
    
    private void createWhirlwind(int offsetSide) {
        for(int i = 0; i < 6; i++) {
            createTwoSide(offsetSide + i, 800 + (125 * i));
        }
        counter = -90;
    }
    
    private void createTwoSide(int offsetSide, double dist) {
        for(int i = 0; i < 2; i++) {
            Side side = new Side((offsetSide + (i * 3)) % 6, dist
                    , 20, Color.BLACK);
            entityList.add(6, side);
        }
    }
}
