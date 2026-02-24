package dxc;

public class RaceStatistics {

    public static void main(String[] args) {

        Race race = new Race(100);

        // Alle Wagen aus RaceCar verwenden
        RaceCar[] cars = RaceCar.getDefaultCars();

        for (RaceCar car : cars) {
            race.addCar(car);
        }

        // 1000 Rennen simulieren
        race.simulate(1000);

        // Statistik ausgeben
        System.out.println("=== Statistik nach 1000 Rennen ===");
        for (RaceCar car : cars) {
            if (car.wins == 0) {
                System.out.println(car.name + " hat kein Rennen gewonnen.");
            } else {
                System.out.println(car.name + " Siege: " + car.wins);
            }
        }
    }
}
