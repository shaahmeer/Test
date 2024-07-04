import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the mathematical operation (Roman numerals and operator): ");
        String input = scanner.nextLine().toUpperCase();
        String[] parts = input.split("\\s+");

        if (parts.length!= 3) {
            System.out.println("Invalid input format. Please enter a valid mathematical operation.");
            return;
        }

        String num1 = parts[0];
        String operator = parts[1];
        String num2 = parts[2];

        RomanCalculator romanCalculator = new RomanCalculator();
        IntegerCalculator integerCalculator = new IntegerCalculator();

        try {
            if (isValidRomanNumeral(num1) && isValidRomanNumeral(num2)) {
                int resultRoman = romanCalculator.calculate(num1, operator, num2);
                System.out.println("Result in Roman numerals: " + romanCalculator.intToRoman(resultRoman));
            } else if (isValidInteger(num1) && isValidInteger(num2)) {
                int resultInteger = integerCalculator.calculate(num1, operator, num2);
                System.out.println("Result in Integer: " + resultInteger);
            } else {
                throw new IllegalArgumentException("Invalid input. Please enter valid Roman numerals or integers.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static boolean isValidRomanNumeral(String s) {
        String[] romanNumerals = {"I", "V", "X", "L", "C", "D", "M"};
        for (String numeral : romanNumerals) {
            if (s.contains(numeral)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

