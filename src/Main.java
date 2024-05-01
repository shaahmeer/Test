import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the mathematical operation (Roman numerals and operator): ");
        String input = scanner.nextLine().toUpperCase();
        String[] parts = input.split("\\s+");

        if (parts.length != 3) {
            System.out.println("Invalid input format. Please enter a valid mathematical operation.");
            return;
        }

        String num1 = parts[0];
        String operator = parts[1];
        String num2 = parts[2];

        RomanCalculator romanCalculator = new RomanCalculator();
        IntegerCalculator integerCalculator = new IntegerCalculator();

        try {
            int resultRoman = romanCalculator.calculate(num1, operator, num2);
            System.out.println("Result in Roman numerals: " + romanCalculator.intToRoman(resultRoman));
        } catch (IllegalArgumentException e) {

        }

        try {
            int resultInteger = integerCalculator.calculate(num1, operator, num2);
            System.out.println("Result in Integer: " + resultInteger);
        } catch (IllegalArgumentException e) {

        }
    }
}
