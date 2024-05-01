
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanCalculator {
    private static final Map<Character, Integer> ROMAN_VALUES = new HashMap<>();

    static {
        ROMAN_VALUES.put('I', 1);
        ROMAN_VALUES.put('V', 5);
        ROMAN_VALUES.put('X', 10);
        ROMAN_VALUES.put('L', 50);
        ROMAN_VALUES.put('C', 100);
        ROMAN_VALUES.put('D', 500);
        ROMAN_VALUES.put('M', 1000);
    }

    private static final String[] ROMAN_NUMERALS = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private static final int[] ROMAN_VALUES_SORTED = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = ROMAN_VALUES_SORTED.length - 1;

        while (num > 0) {
            if (num >= ROMAN_VALUES_SORTED[i]) {
                sb.append(ROMAN_NUMERALS[i]);
                num -= ROMAN_VALUES_SORTED[i];
            } else {
                i--;
            }
        }

        return sb.toString();
    }

    public int calculate(String roman1, String operator, String roman2) {
        int num1 = romanToInteger(roman1);
        int num2 = romanToInteger(roman2);

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator. Please use +, -, *, or /.");
        }

        return result;
    }

    int romanToInteger(String roman) {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char romanChar = roman.charAt(i);
            if (!ROMAN_VALUES.containsKey(romanChar)) {
                throw new IllegalArgumentException("Invalid Roman numeral: " + romanChar);
            }

            Integer value = ROMAN_VALUES.get(romanChar);
            if (value == null) {
                throw new IllegalArgumentException("Value not found for Roman numeral: " + romanChar);
            }

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }

        return result;
    }



}
