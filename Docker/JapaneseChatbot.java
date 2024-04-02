import java.util.Scanner;

public class JapaneseChatbot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Konnichiwa! Watashi wa chatbot desu. Douzo hanashikakete kudasai.");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sayounara")) {
                System.out.println("Sayounara! Mata aimashou!");
                break;
            } else {
                String response = getResponse(input);
                System.out.println(response);
            }
        }

        scanner.close();
    }

    public static String getResponse(String input) {
        // Check for basic greetings
        if (input.equalsIgnoreCase("ohayou")) {
            return "Ohayou gozaimasu!";
        } else if (input.equalsIgnoreCase("konnichiwa")) {
            return "Konnichiwa!";
        } else if (input.equalsIgnoreCase("konbanwa")) {
            return "Konbanwa!";
        }

        // Check for basic arithmetic operations
        if (input.matches(".*[0-9]+.*[+\\-*/].*[0-9]+.*")) {
            try {
                String[] tokens = input.split("[+\\-*/]");
                double operand1 = Double.parseDouble(tokens[0].trim());
                double operand2 = Double.parseDouble(tokens[1].trim());
                char operator = input.replaceAll("[0-9 ]", "").charAt(0);

                double result = 0;

                switch (operator) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        if (operand2 == 0) {
                            return "Error: Division by zero";
                        }
                        result = operand1 / operand2;
                        break;
                    default:
                        return "Error: Invalid operator";
                }

                return "Sore wa: " + result;
            } catch (NumberFormatException e) {
                return "Error: Invalid input for arithmetic operation";
            }
        }

        return "Sumimasen, yoku wakarimasen.";
    }
}
