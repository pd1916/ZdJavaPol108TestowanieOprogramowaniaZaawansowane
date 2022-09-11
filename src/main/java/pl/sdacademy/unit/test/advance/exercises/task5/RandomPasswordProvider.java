package pl.sdacademy.unit.test.advance.exercises.task5;

import java.util.UUID;

public class RandomPasswordProvider {

    public String getRandomPassword() {
        //12345-45678-98978
        return UUID.randomUUID().toString();
    }
}
