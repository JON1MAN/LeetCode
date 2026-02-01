package codewars.kata3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

public class BinomialExpansion {

    private static final Map<PatternName, Pattern> patterMap = Map.of(
            PatternName.A_COEFFICIENT, Pattern.compile("\\((-?\\d*)[a-zA-Z]"),
            PatternName.B_COEFFICIENT, Pattern.compile("[a-zA-Z]([+-]?\\d*)\\)"),
            PatternName.POWER, Pattern.compile("\\^(\\d+)")
    );

    public static String expand(String expr) {
        var aCoefficient = getNumericValue(extractForPattern(expr, PatternName.A_COEFFICIENT), true);
        var bCoefficient = getNumericValue(extractForPattern(expr, PatternName.B_COEFFICIENT), false);
        var power = getNumericValue(extractForPattern(expr, PatternName.POWER), true);
        var expressionCoefficients = findExpressionCoefficientsAsStrings(aCoefficient, bCoefficient, power);
        var independentVariableChar = getIndependentVariableChar(expr);
        return buildResultExpression(expressionCoefficients, independentVariableChar, power);
    }

    private static String buildResultExpression(
            List<String> expressionCoefficients,
            Character independentVariableChar,
            int power
    ) {
        StringBuilder builder = new StringBuilder();
        for (int n = power; n >= 0; n--) {
            if (n != power && isZero(expressionCoefficients, power - n))
                continue;
            builder.append(buildRoot(expressionCoefficients, independentVariableChar, power, n));
        }
        return builder.toString();
    }

    private static boolean isZero(List<String> expressionCoefficients, int index) {
        return Long.parseLong(expressionCoefficients.get(index)) == 0;
    }

    private static String buildRoot(
            List<String> expressionCoefficients,
            Character independentVariableChar,
            int expressionPower, int n
    ) {
        if (n == 0) {
            return expressionCoefficients.getLast();
        } else if (n == 1) {
            return "%s%c".formatted(expressionCoefficients.get(expressionPower - n), independentVariableChar);
        }
        return "%s%c^%d".formatted(expressionCoefficients.get(expressionPower - n), independentVariableChar, n);
    }

    public static String extractForPattern(String expr, PatternName patternName) {
        var matcher = patterMap.get(patternName).matcher(expr);
        return matcher.find() ? matcher.group(1) : "";
    }

    private static Character getIndependentVariableChar(String expr) {
        return expr.codePoints()
                .mapToObj(code -> (char) code)
                .filter(Character::isAlphabetic)
                .findFirst()
                .orElse('x');
    }

    public static int getNumericValue(String coefficient, boolean isA) {
        return switch (coefficient) {
            case "" -> isA ? 1 : 0;
            case "-" -> -1;
            default -> Integer.parseInt(coefficient);
        };
    }

    public static List<String> findExpressionCoefficientsAsStrings(int a, int b, int n) {
        var numericExpressionCoefficients = findExpressionCoefficients(a, b, n);
        return reprocessToString(numericExpressionCoefficients);
    }

    public static List<String> reprocessToString(List<Long> expressionCoefficients) {
        List<String> result = new ArrayList<>();

        result.add(formatFirst(expressionCoefficients));

        expressionCoefficients.stream()
                .skip(1)
                .map(BinomialExpansion::mapCoefficient)
                .forEach(result::add);

        return result;
    }

    private static String formatFirst(List<Long> expressionCoefficients) {
        var firstRoot = expressionCoefficients.getFirst();
        if (firstRoot == 1 && expressionCoefficients.size() > 1) {
            return "";
        } else if (firstRoot == -1 && expressionCoefficients.size() > 1) {
            return "-";
        } else {
            return String.valueOf(firstRoot);
        }
    }

    private static String mapCoefficient(Long coefficient) {
        if (coefficient > 0) {
            return "+%d".formatted(coefficient);
        } else {
            return "%d".formatted(coefficient);
        }
    }

    public static List<Long> findExpressionCoefficients(int a, int b, int n) {
        return LongStream.rangeClosed(0, n)
                .map(k -> buildRoot(a, b, n, k))
                .boxed()
                .toList()
                .reversed();
    }

    private static Long buildRoot(int a, int b, int n, long k) {
        return getBinomialCoefficient(n, k) * (intPow(a, k) * intPow(b, n - k));
    }

    private static Long intPow(int base, long exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }


    public static Long getBinomialCoefficient(int n, long k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static Long factorial(long number) {
        return LongStream.rangeClosed(1, number)
                .reduce((a, b) -> a * b)
                .orElse(1);
    }

    public enum PatternName {
        A_COEFFICIENT,
        B_COEFFICIENT,
        POWER
    }
}
