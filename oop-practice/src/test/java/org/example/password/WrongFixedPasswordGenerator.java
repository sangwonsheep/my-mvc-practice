package org.example.password;

public class WrongFixedPasswordGenerator implements PasswordGeneratePolicy {

    @Override
    public String generatePassword() {
        return "ab";
    }
}
