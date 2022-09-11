package pl.sdacademy.unit.test.advance.exercises.task5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PasswordResetService {
    private static final String BODY_TEMPLATE =
            "Twoje tymczasowe hasło wygenerowane dnia REPLACE_DATE o godzinie REPLACE_TIME to REPLACE_NEW_PASS";

    private DateTimeProvider dateTimeProvider;
    private RandomPasswordProvider randomPasswordProvider;

    public PasswordResetService(DateTimeProvider dateTimeProvider, RandomPasswordProvider randomPasswordProvider) {
        this.dateTimeProvider = dateTimeProvider;
        this.randomPasswordProvider = randomPasswordProvider;
    }

    public String generateEmailBody() {
        //String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime currentDateTime = dateTimeProvider.getCurrentDateTime();
        String newPassword = randomPasswordProvider.getRandomPassword();
        return BODY_TEMPLATE
                .replace("REPLACE_DATE", currentDateTime.toLocalDate().toString())
                .replace("REPLACE_TIME", currentDateTime.toLocalTime().toString())
                .replace("REPLACE_NEW_PASS", newPassword);
    }
}
