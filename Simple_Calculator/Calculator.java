import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int check = 1;

        while (check != 0) {
            System.out.println("Usage: <value1> <operator> <value2>");
            String input = scanner.nextLine();

            String[] inputList = input.split(" ");

            if (inputList.length == 3) {
                try {
                    double value1 = Double.parseDouble(inputList[0]);
                    String ops = inputList[1];
                    double value2 = Double.parseDouble(inputList[2]);

                    Operator op = new Operator();

                    op.setOps(ops);
                    op.setValue1(value1);
                    op.setValue2(value2);

                    double result = performOperation(op);

                    System.out.println("Result: " + result);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numeric values for the operands.");
                    continue;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

            } else {
                System.out.println("Invalid input format. Please enter in the format: ");
                continue;
            }
            do {
                try {
                    System.out.print("Press 0 to exit, or any other number to continue: ");
                    check = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number");
                    check = -1;
                }
            } while (check == -1);
        }
    }

    public static double performOperation(Operator operator) {

        return switch (operator.ops) {
            case "+" -> operator.add(operator.value1, operator.value2);
            case "-" -> operator.subtract(operator.value1, operator.value2);
            case "*" -> operator.multiply(operator.value1, operator.value2);
            case "/" -> {
                if (operator.value2 == 0) {
                    throw new IllegalArgumentException("Error: Division by zero is not allowed.");
                }
                yield operator.divide(operator.value1, operator.value2);
            }
            case "%" -> {
                if (operator.value2 == 0) {
                    throw new IllegalArgumentException("Error: Division by zero is not allowed.");
                }
                yield operator.modulus(operator.value1, operator.value2);
            }
            default ->
                    throw new IllegalStateException("Invalid operator: " + operator.ops + "Supported operators are +, -, *, /, %.");
        };
    }
}