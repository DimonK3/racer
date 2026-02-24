package dxc;

import java.util.Random;

public class RaceCar {

    String name;
    int diceCount;
    int diceSides;
    int bonus;

    int position = 0;
    int wins = 0;

    Random random = new Random();

    public RaceCar(String name, int diceCount, int diceSides, int bonus) {
        if(diceCount < 1) throw new IllegalArgumentException("Mindestens 1 Würfel nötig");
        if(diceSides < 1) throw new IllegalArgumentException("Würfel muss mindestens eine Seite haben");
    }
}
