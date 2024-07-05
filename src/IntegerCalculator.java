public class IntegerCalculator {
    public int calculate(String num1, String operator, String num2) {
        int intNum1 = Integer.parseInt(num1);
        int intNum2 = Integer.parseInt(num2);


        int result;
        switch (operator) {
            case "+" -> result = intNum1 + intNum2;
            case "-" -> result = intNum1 - intNum2;
            case "*" -> result = intNum1 * intNum2;
            case "/" -> {
                if (intNum2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                result = intNum1 / intNum2;
            }
            default -> throw new IllegalArgumentException("Invalid operator. Please use +, -, *, or /.");
        }

        return result;
    }
}
