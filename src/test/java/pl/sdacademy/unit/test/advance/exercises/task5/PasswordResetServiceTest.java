package pl.sdacademy.unit.test.advance.exercises.task5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordResetServiceTest {

    @Mock
    private DateTimeProvider dateTimeProvider;

    @Mock
    private RandomPasswordProvider randomPasswordProvider;

    @InjectMocks
    private PasswordResetService passwordResetService;

    @Test
    void shouldGenerateEmailBody() {
        //given
        when(dateTimeProvider.getCurrentDateTime()).thenReturn(
                LocalDateTime.of(2015, 11, 28, 16, 05, 30));
        when(randomPasswordProvider.getRandomPassword()).thenReturn("qwerty");
        String expectedResult = "Twoje tymczasowe hasło wygenerowane dnia 2015-11-28 o godzinie 16:05:30 to qwerty";
        //when
        String result = passwordResetService.generateEmailBody();
        System.out.println(result);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertj
    }

}