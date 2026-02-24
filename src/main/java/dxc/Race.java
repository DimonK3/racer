package dxc;

import java.util.ArrayList;
import java.util.List;

public class Race {

    List<RaceCar> cars = new ArrayList<>();
    int finishLine;

    public Race(int finishLine) {
        this.finishLine = finishLine;
    }

    public void addCar(RaceCar car) {
        cars.add(car);
    }

    public RaceCar runRace() {
        while (true) {
            for (RaceCar car : cars) {
                car.position += car.roll();

                if (car.position >= finishLine) {
                    car.wins++;
                    return car;
                }
            }
        }
    }

    public void resetRace() {
        for (RaceCar car : cars) {
            car.reset();
        }
    }

    public void simulate(int runs) {
        for (int i = 0; i < runs; i++) {
            RaceCar winner = runRace();
            resetRace();
        }
    }

    public void printStatistics() {
        for (RaceCar car : cars) {
            System.out.println(car.name + " Siege: " + car.wins);
        }
    }
}