package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @MethodSource("provideDataForMultiply")
    void shouldMultiplyTwoDigits(int firstDigit, int secondDigit, int expectedResult) {
        //when
        int result = calculator.multiply(firstDigit, secondDigit);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertj
    }

    private static Stream<Arguments> provideDataForMultiply() {
        return Stream.of(
                Arguments.of(2, 3, 6),
                Arguments.of(2, 0, 0),
                Arguments.of(0, 1, 0),
                Arguments.of(-2, 4, -8)
        );
    }

}