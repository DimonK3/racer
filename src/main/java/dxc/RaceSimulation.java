package dxc;

public class RaceSimulation {

    public static void main(String[] args) {

        Race race = new Race(100);

        // Alle Wagen aus RaceCar verwenden
        RaceCar[] cars = RaceCar.getDefaultCars();

        for (RaceCar car : cars) {
            race.addCar(car);
        }

        race.simulate(10000);
        race.printStatistics();
    }
}
