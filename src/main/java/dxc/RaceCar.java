package dxc;

import java.util.Random;

public class RaceCar {

    public String name;
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

    // Statische Methode: liefert alle 12 Wagen
    public static RaceCar[] getDefaultCars() {
        return new RaceCar[] {
                new RaceCar("Alpha",   1, 6, 0),
                new RaceCar("Bravo",   2, 6, 0),
                new RaceCar("Charlie", 1, 8, 1),
                new RaceCar("Delta",   3, 4, -1),
                new RaceCar("Echo",    2, 8, 0),
                new RaceCar("Foxtrot", 1, 12, -2),
                new RaceCar("Golf",    4, 3, 0),
                new RaceCar("Hotel",   2, 10, -1),
                new RaceCar("India",   3, 6, -2),
                new RaceCar("Juliet",  1, 20, -5),
                new RaceCar("Kilo",    5, 2, 0),
                new RaceCar("Lima",    2, 12, -3)
        };
    }
}