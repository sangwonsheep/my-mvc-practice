package org.example.calculator;

public class PositiveNumber {
    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (isNegativeNumber(value)) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
    }

    private boolean isNegativeNumber(int number) {
        return number <= 0;
    }

    public int toInt() {
        return value;
    }
}
