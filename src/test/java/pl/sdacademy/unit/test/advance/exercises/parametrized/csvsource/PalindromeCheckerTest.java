package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    /*
    true:
    kajak
    wow
    Radar
    oko
    ala
    kobyla ma maly bok

    false:
    java
    programowanie

     */

    // na potrzeby testó zrobiliśmy jedną matodę testową, ale nie powinno
    // się tak robić, lepiej rozbić np. na dwie: jedna dla true, a druga dla false
    @ParameterizedTest
    @CsvSource({
            "'I did, did I', true",
            "kajak, true",
            "wow, true",
            "Radar, true",
            "oko, true",
            "ala, true",
            "kobyla ma maly bok, true",
            "java, false",
            "programowanie, false"})
    void shouldVerifyPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); // junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv")
    void shouldVerifyPalindrome_csvFileSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); // junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/palindrome_2.csv",
            numLinesToSkip = 10,
            delimiter = '|')
    void shouldVerifyPalindrome_csvFileSource_2(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); // junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }
}