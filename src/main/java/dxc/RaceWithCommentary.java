package dxc;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class RaceWithCommentary {

    public static void main(String[] args) {

        RaceCar[] cars = RaceCar.getDefaultCars();
        int finishLine = 100;
        int totalRaces = 1;


        for (int raceNumber = 1; raceNumber <= totalRaces; raceNumber++) {
            System.out.println("=== Rennen " + raceNumber + " startet ===");

            // Wagen zurücksetzen
            for (RaceCar car : cars) {
                car.reset();
            }

            boolean raceFinished = false;
            RaceCar currentLeader = null;

            // Status für „weit zurück“ Wagen
            Map<RaceCar, Boolean> farBehindStatus = new HashMap<>();
            for (RaceCar car : cars) {
                farBehindStatus.put(car, false);
            }

            while (!raceFinished) {

                // Rundenbewegung
                for (RaceCar car : cars) {
                    car.position += car.roll();
                }

                // Führenden bestimmen
                RaceCar leader = cars[0];
                for (RaceCar car : cars) {
                    if (car.position > leader.position) {
                        leader = car;
                    }
                }

                // Kommentator: Führungswechsel
                if (leader != currentLeader) {
                    System.out.println("Kommentator: " + leader.name + " übernimmt die Spitze mit " + leader.position + " Metern!");
                    currentLeader = leader;
                }

                // Immer ausgeben, wie weit der Erste ist
                System.out.println("Kommentator: Der Führende ist " + leader.name + " bei " + leader.position + " Metern.");

                // Kommentator: Wagen weit zurück bündeln
                List<String> farBehindCars = new ArrayList<>();
                for (RaceCar car : cars) {
                    if (car != leader) {
                        int distance = leader.position - car.position;
                        boolean wasFarBehind = farBehindStatus.get(car);

                        if (distance >= 10 && !wasFarBehind) {
                            farBehindCars.add(car.name + " (" + car.position + " m)");
                            farBehindStatus.put(car, true);
                        } else if (distance < 10 && wasFarBehind) {
                            farBehindStatus.put(car, false);
                        }
                    }
                }

                if (!farBehindCars.isEmpty()) {
                    System.out.println("Kommentator: Folgende Wagen fallen weit zurück: " + String.join(", ", farBehindCars));
                }

                // Prüfen, ob jemand das Ziel erreicht hat
                for (RaceCar car : cars) {
                    if (car.position >= finishLine) {
                        System.out.println("Kommentator: " + car.name + " hat das Ziel erreicht und gewinnt das Rennen!");
                        car.wins++;
                        raceFinished = true;
                        break;
                    }
                }
            }
        }

        // Endstatistik
        System.out.println("\n=== Endstatistik ===");
        for (RaceCar car : cars) {
            System.out.println(car.name + " Siege: " + car.wins);
        }
    }
}