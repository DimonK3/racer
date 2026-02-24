import dxc.Race;
import dxc.RaceCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceCarTest {

    @Test
    @DisplayName("Should throw IllegalArgumentException when Dice Count is below 1")
    public void shouldThrowErrorWhenDiceCountBelow1() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new RaceCar("car", 0, 6, 0);
        });

        String expectedMessage = "Mindestens 1 Würfel nötig";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when Dice Sides are below 1")
    public void shouldThrowErrorWhenDiceSidesBelow1() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new RaceCar("car", 2, 0, 0);
        });

        String expectedMessage = "Würfel muss mindestens eine Seite haben";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("Should win race atleast once in a thousand runs")
    public void shouldWinAtLeastOnceInThousandRuns() {

        Race race = new Race(100);

        RaceCar car = new RaceCar("car", 2, 6, 0);
        race.addCar(car);

        race.simulate(1000);

        String expectedMessage = "Das Auto hat in 1000 Rennen kein einziges Mal gewonnen";
        String actualMessage = car.wins > 0 ? "OK" : expectedMessage;

        assertTrue(actualMessage.contains("OK"), expectedMessage);
    }
}
