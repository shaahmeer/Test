import java.util.Map;

public class RomanCalculator {
    private final Map<String, Integer> romanMap;

    public RomanCalculator(Map<String, Integer> romanMap) {
        this.romanMap = romanMap;
    }

    public int calculate(String num1, String operator, String num2) {
        int operand1 = parseRomanNumeral(num1);
        int operand2 = parseRomanNumeral(num2);

        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator. Please use +, -, *, or /.");
        }
    }

    private int parseRomanNumeral(String numeral) {
        if (!romanMap.containsKey(numeral)) {
            throw new IllegalArgumentException("Invalid Roman numeral. Please enter a valid Roman numeral from I to X.");
        }

        return romanMap.get(numeral);
    }
}
