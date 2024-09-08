package org.example.password;

public class CorrectFixedPasswordGenerator implements PasswordGeneratePolicy {
    @Override
    public String generatePassword() {
        return "abcdefgh";
    }
}
