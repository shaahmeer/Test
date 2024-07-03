public class IntegerCalculator {
    public int calculate(String num1, String operator, String num2) {
        int intNum1 = Integer.parseInt(num1);
        int intNum2 = Integer.parseInt(num2);


        int result;
        switch (operator) {
            case "+":
                result = intNum1 + intNum2;
                break;
            case "-":
                result = intNum1 - intNum2;
                break;
            case "*":
                result = intNum1 * intNum2;
                break;
            case "/":
                if (intNum2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                result = intNum1 / intNum2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator. Please use +, -, *, or /.");
        }

        return result;
    }
}
