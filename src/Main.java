import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the mathematical operation (Roman numerals and operator): ");
        String input = scanner.nextLine().toUpperCase();
        String[] parts = input.split("\\s+");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid input format. Please enter a valid mathematical operation.");
        }

        String num1 = parts[0];
        String operator = parts[1];
        String num2 = parts[2];

        RomanCalculator romanCalculator = new RomanCalculator();
        IntegerCalculator integerCalculator = new IntegerCalculator();

        try {
            if (isValidRomanNumeral(num1) && isValidRomanNumeral(num2)) {
                int resultRoman = romanCalculator.calculate(num1, operator, num2);
                if (resultRoman > 10) {
                    throw new ArithmeticException("Result cannot be greater than 10 in Roman numerals.");
                }
                if (resultRoman < 1) {
                    throw new ArithmeticException("Result cannot be less than 1 in Roman numerals.");
                }
                if (resultRoman == 0) {
                    System.out.println("Result in Roman numerals: Nulla");
                } else {
                    System.out.println("Result in Roman numerals: " + romanCalculator.intToRoman(resultRoman));
                }
            } else if (isValidInteger(num1) && isValidInteger(num2)) {
                int resultInteger = integerCalculator.calculate(num1, operator, num2);
                System.out.println("Result in Integer: " + resultInteger);
            } else {
                throw new IllegalArgumentException("Invalid input. Please enter valid Roman numerals or integers.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isValidRomanNumeral(String s) {
        String[] romanNumerals = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        for (String numeral : romanNumerals) {
            if (s.equals(numeral)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidInteger(String s) {
        try {
            int num = Integer.parseInt(s);
            return num >= 1 && num <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}