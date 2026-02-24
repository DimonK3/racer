import dxc.Race;
import dxc.RaceCar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceCarTest {

    @Test
    public void shouldThrowErrorWhenDiceCountBelow1() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new RaceCar("car", 0, 6, 0);
        });

        String expectedMessage = "Mindestens 1 Würfel nötig";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldThrowErrorWhenDiceSidesBelow1() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new RaceCar("car", 2, 0, 0);
        });

        String expectedMessage = "Würfel muss mindestens eine Seite haben";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
