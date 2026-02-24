package dxc;

public class RaceSimulation {

    public static void main(String[] args) {

        Race race = new Race(100);

        race.addCar(new RaceCar("Car1", 1, 6, 0));
        race.addCar(new RaceCar("Car2", 2, 6, -2));
        race.addCar(new RaceCar("Car3", 1, 12, 0));
        race.addCar(new RaceCar("Car4", 3, 4, -1));
        race.addCar(new RaceCar("Car5", 2, 8, 0));
        race.addCar(new RaceCar("Car6", 1, 20, -5));
        race.addCar(new RaceCar("Car7", 4, 3, 0));
        race.addCar(new RaceCar("Car8", 2, 10, -3));
        race.addCar(new RaceCar("Car9", 3, 6, -2));
        race.addCar(new RaceCar("Car10", 1, 8, 1));
        race.addCar(new RaceCar("Car11", 5, 2, 0));
        race.addCar(new RaceCar("Car12", 2, 12, -4));

        race.simulate(10000);
        race.printStatistics();
    }
}
