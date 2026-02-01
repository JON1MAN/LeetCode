package codewars.kata3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinomialExpansionTester {

    @Nested
    class Expand {

        @Test
        void test() {
            int x = -1;
            String s = String.format("%d%c^%d", x, 'x', 2);
            System.out.println(s);
        }

        @ParameterizedTest
        @MethodSource("expandsExpressionArguments")
        void expandsExpression(String expression, String expected) {
            var actual = BinomialExpansion.expand(expression);
            assertEquals(expected, actual);
        }

        private static Stream<Arguments> expandsExpressionArguments() {
            return Stream.of(
                    Arguments.of("(x+1)^2", "x^2+2x+1"),
                    Arguments.of("(x+1)^0", "1"),
                    Arguments.of("(x+1)^1", "x+1"),
                    Arguments.of("(x-1)^0", "1"),
                    Arguments.of("(x-1)^1", "x-1"),
                    Arguments.of("(x-1)^2", "x^2-2x+1"),
                    Arguments.of("(5m+3)^4", "625m^4+1500m^3+1350m^2+540m+81"),
                    Arguments.of("(2x-3)^3", "8x^3-36x^2+54x-27"),
                    Arguments.of("(7x-7)^0", "1"),
                    Arguments.of("(9x)^2", "81x^2")
            );
        }
    }

    @Nested
    class ABCoefficients {
        @ParameterizedTest()
        @MethodSource("argumentsForACoefficient")
        void findsACoefficient_whenMatch(String expression, String expectedCoefficient) {
            var actual = BinomialExpansion.extractForPattern(
                    expression, BinomialExpansion.PatternName.A_COEFFICIENT);
            assertEquals(expectedCoefficient, actual);
        }

        @ParameterizedTest()
        @MethodSource("argumentsForBCoefficient")
        void findsBCoefficient_whenMatch(String expression, String expectedCoefficient) {
            var actual = BinomialExpansion.extractForPattern(
                    expression, BinomialExpansion.PatternName.B_COEFFICIENT);
            assertEquals(expectedCoefficient, actual);
        }

        @ParameterizedTest()
        @MethodSource("argumentsForGetsNumericCoefficient")
        void getsNumericCoefficient(String coefficient, boolean isA, int expectedCoefficient) {
            var actual = BinomialExpansion.getNumericValue(coefficient, isA);
            assertEquals(expectedCoefficient, actual);
        }

        private static Stream<Arguments> argumentsForGetsNumericCoefficient() {
            return Stream.of(
                    Arguments.of("3", true, 3),
                    Arguments.of("-3", true, -3),
                    Arguments.of("", true, 1),
                    Arguments.of("", false, 0),
                    Arguments.of("-", true, -1)
            );
        }

        private static Stream<Arguments> argumentsForBCoefficient() {
            return Stream.of(
                    Arguments.of("(2x+3)", "+3"),
                    Arguments.of("(-2x-3)", "-3"),
                    Arguments.of("(b)", "")
            );
        }

        private static Stream<Arguments> argumentsForACoefficient() {
            return Stream.of(
                    Arguments.of("(2x + 3)", "2"),
                    Arguments.of("(-2x + 3)", "-2"),
                    Arguments.of("(b - 3)", ""),
                    Arguments.of("(-c + 3)", "-")
            );
        }
    }

    @Nested
    class FindExpressionCoefficients {
        @ParameterizedTest()
        @MethodSource("argumentsForFactorial")
        void findsExpressionCoefficients(int a, int b, int root, List<Integer> expected) {
            var actual = BinomialExpansion.findExpressionCoefficients(a, b, root);
            assertEquals(expected, actual);
        }

        private static Stream<Arguments> argumentsForFactorial() {
            return Stream.of(
                    Arguments.of(1, -1, 3, List.of(1, -3, 3, -1)),
                    Arguments.of(1, 1, 2, List.of(1, 2, 1))
            );
        }
    }

    @Nested
    class ExtractPower {

        @ParameterizedTest
        @MethodSource("extractPowerArguments")
        void extractsPower(String expression, String expected) {
            var actual = BinomialExpansion.extractForPattern(
                    expression, BinomialExpansion.PatternName.POWER);
            assertEquals(expected, actual);
        }

        private static Stream<Arguments> extractPowerArguments() {
            return Stream.of(
                    Arguments.of("(2x + 3) ^2", "2"),
                    Arguments.of("(-2x + 3) ^0", "0")
            );
        }
    }

    @Nested
    class Factorial {
        @ParameterizedTest()
        @MethodSource("argumentsForFactorial")
        void findsFactorial(int number, int expected) {
            var actual = BinomialExpansion.factorial(number);
            assertEquals(expected, actual);
        }

        private static Stream<Arguments> argumentsForFactorial() {
            return Stream.of(
                    Arguments.of(0, 1),
                    Arguments.of(1, 1),
                    Arguments.of(2, 2),
                    Arguments.of(3, 6),
                    Arguments.of(4, 24)
            );
        }
    }

    @Nested
    class GetBinomialCoefficient {
        @ParameterizedTest()
        @MethodSource("argumentsForFactorial")
        void findsBinomialCoefficient(int n, int k, int expected) {
            var actual = BinomialExpansion.getBinomialCoefficient(n, k);
            assertEquals(expected, actual);
        }

        private static Stream<Arguments> argumentsForFactorial() {
            return Stream.of(
                    Arguments.of(0, 0, 1),
                    Arguments.of(4, 0, 1),
                    Arguments.of(4, 1, 4),
                    Arguments.of(4, 2, 6),
                    Arguments.of(4, 3, 4)
            );
        }
    }
}
