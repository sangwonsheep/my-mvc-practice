package org.example.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 연산을 수행한다.")
    void additionTest() {
        int result = Calculator.calculate(new PositiveNumber(1), "+", new PositiveNumber(2));

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 연산을 수행한다.")
    void subtractionTest() {
        int result = Calculator.calculate(new PositiveNumber(1), "-", new PositiveNumber(2));

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("계산기 수행")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(PositiveNumber operand1, String operator, PositiveNumber operand2, int result) {
        int calResult = Calculator.calculate(operand1, operator, operand2);
        assertThat(calResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(new PositiveNumber(1), "+", new PositiveNumber(2), 3),
                arguments(new PositiveNumber(1), "-", new PositiveNumber(2), -1),
                arguments(new PositiveNumber(4), "*", new PositiveNumber(2), 8),
                arguments(new PositiveNumber(4), "/", new PositiveNumber(2), 2)
        );
    }
}
