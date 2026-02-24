package dxc;

import java.util.Random;

public class RaceCar {

    String name;
    int diceCount;
    int diceSides;
    int bonus;

    int position = 0;
    public int wins = 0;

    Random random = new Random();

    public RaceCar(String name, int diceCount, int diceSides, int bonus) {
        if(diceCount < 1) throw new IllegalArgumentException("Mindestens 1 Würfel nötig");
        if(diceSides < 1) throw new IllegalArgumentException("Würfel muss mindestens eine Seite haben");

        this.name = name;
        this.diceCount = diceCount;
        this.diceSides = diceSides;
        this.bonus = bonus;
    }

    public int roll() {
        int sum = 0;
        for (int i = 0; i < diceCount; i++) {
            sum += random.nextInt(diceSides) + 1;
        }

        sum += bonus;

        return Math.max(1, sum);
    }

    public void reset() {
        position = 0;
    }
}
