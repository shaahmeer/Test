
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical operation (Roman or Integer):");
        String input = scanner.nextLine();
        scanner.close();

        Map<String, Integer> romanMap = createRomanMap();
        RomanCalculator romanCalculator = new RomanCalculator(romanMap);
        IntegerCalculator integerCalculator = new IntegerCalculator();

        try {
            String[] parts = input.split("\\s+");
            if (parts[0].matches("\\d+") && parts[2].matches("\\d+")) {
                int result = integerCalculator.calculate(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
                System.out.println("Result: " + result + " (Integer)");
            } else {
                int result = romanCalculator.calculate(parts[0], parts[1], parts[2]);
                System.out.println("Result: " + result + " (Roman)");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Map<String, Integer> createRomanMap() {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("II", 2);
        romanMap.put("III", 3);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("VI", 6);
        romanMap.put("VII", 7);
        romanMap.put("VIII", 8);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);

        return romanMap;
    }
}
