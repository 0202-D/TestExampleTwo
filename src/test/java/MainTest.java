import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Dm.Petrov
 * DATE: 16.07.2022
 */
public class MainTest {
    Main sut;

    @BeforeEach
    public void init() {
        System.out.println("test started...");
        sut = new Main();
    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started ...");
    }

    @AfterAll
    public static void finished() {
        System.out.println("tests finished !!!");
    }

    @AfterEach
    public void testFinished() {
        System.out.println("test finished!!!");
    }

    @Test
    public void calculatingTheNumberOfLargeSizedBooks() {
        int[] arr = {56, 233, 450, 567, 721};
        int bookSize = 70;
        int result = sut.calculatingTheNumberOfLargeSizedBooks(arr, bookSize);
        assertThat(4, is(result));
    }

    @Test
    public void calculatingTheNumberOfLargeSizedBooks2() {
        int[] arr = {56, 233, 350, 567, 621};
        int bookSize = -100;
        int result = sut.calculatingTheNumberOfLargeSizedBooks(arr, bookSize);
        assertThat(-1, is(result));
    }

    @Test
    public void calculatingTheNumberOfLargeSizedBooks3() {
        int[] arr = {56, 233, 350, 667, 721, 1066, 1117};
        int bookSize = 2000;
        int result = sut.calculatingTheNumberOfLargeSizedBooks(arr, bookSize);
        assertThat(0, is(result));

    }

    @Test
    public void calculatingTheNumberOfLargeSizedBooks4() {
        int[] arr = {56, 133, 150};
        int bookSize = 15;
        int result = sut.calculatingTheNumberOfLargeSizedBooks(arr, bookSize);
        assertThat(5, is(result));
    }

    @Test()
    public void nullPointerException() {
        int[] arr = null;
        int bookSize = 34;
        assertThrows(NullPointerException.class, () -> sut.calculatingTheNumberOfLargeSizedBooks(arr, bookSize));

    }

    @ParameterizedTest
    @MethodSource("source")
    public void calculatingTheNumberOfLargeSizedBooks5(int[] arr, int bookSize, int expected) {
        int result = sut.calculatingTheNumberOfLargeSizedBooks(arr, bookSize);
        assertThat(expected, is(result));
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(new int[]{75, 75, 75, 88, 89, 111}, 75, 3),
                Arguments.of(new int[]{333, 555, 555, 999}, 555, 1),
                Arguments.of(new int[]{75, 55, 89, 89, 89}, 89, 0));
    }
    @Test
    public void calculatingTheNumberOfLargeSizedBooks5() {
        int[] arr = {800, 25, 17, 567};
        int bookSize = 17;
        int result = sut.calculatingTheNumberOfLargeSizedBooks(arr, bookSize);
        assertThat(1, not(result));

    }
}
