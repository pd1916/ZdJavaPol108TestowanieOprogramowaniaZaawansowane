package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    /*
    index, expectedResult
    0, 0
    1, 1
    4, 3
    6, 8
    8, 21
     */

    @ParameterizedTest
    //@MethodSource("dataProvider")
    //@MethodSource("pełnaSciezkaDoKlasy + . + NazwaKlasy + # + nazwaMetody")
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider.FibonacciDataProvider#dataProvider")
    void shouldReturnCorrectValue(int input, int expectedResult) {
        //when
        int result = Fibonacci.getValueFromIndex(input);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertj
    }

//    private static Stream<Arguments> dataProvider() {
//        return Stream.of(
//                Arguments.of(0, 0),
//                Arguments.of(1, 1),
//                Arguments.of(4, 3),
//                Arguments.of(6, 8),
//                Arguments.of(8, 21)
//        );
//    }

}