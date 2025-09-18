
package unitconvert;
import java.util.*;

public class UnitConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Simple Unit Converter Program");

        while (running) {
            printMainMenu();
            int choice = getInt(sc, "Enter category: ");

            switch (choice) {
                case 1: // length
                    handleLength(sc);
                    break;
                case 2: // weight
                    handleWeight(sc);
                    break;
                case 3: // temperature
                    handleTemperature(sc);
                    break;
                case 4: // quit
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }

    //main prompt menu
    private static void printMainMenu() {
        System.out.println("\nChoose a category:");
        System.out.println("1. Length");
        System.out.println("2. Weight");
        System.out.println("3. Temperature");
        System.out.println("4. Quit");
    }

    //length conversions
    private static void handleLength(Scanner sc) {
        System.out.println("\nLength conversions:");
        System.out.println("1. Meters → Kilometers");
        System.out.println("2. Kilometers → Meters");
        int subChoice = getInt(sc, "Enter choice: ");

        if (subChoice == 1) {
            convert(sc, "Meters", "Kilometers", 1.0 / 1000);
        } else if (subChoice == 2) {
            convert(sc, "Kilometers", "Meters", 1000.0);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    //weight conversions
    private static void handleWeight(Scanner sc) {
        System.out.println("\nWeight conversions:");
        System.out.println("1. Kilograms → Pounds");
        System.out.println("2. Pounds → Kilograms");
        int subChoice = getInt(sc, "Enter choice: ");

        if (subChoice == 1) {
            convert(sc, "Kilograms", "Pounds", 2.20462);
        } else if (subChoice == 2) {
            convert(sc, "Pounds", "Kilograms", 1.0 / 2.20462);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    //temperature conversions
    private static void handleTemperature(Scanner sc) {
        System.out.println("\nTemperature conversions:");
        System.out.println("1. Celsius → Fahrenheit");
        System.out.println("2. Fahrenheit → Celsius");
        int subChoice = getInt(sc, "Enter choice: ");

        if (subChoice == 1) {
            double celsius = getDouble(sc, "Enter Celsius: ");
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.println(celsius + " °C = " + fahrenheit + " °F");
        } else if (subChoice == 2) {
            double f = getDouble(sc, "Enter Fahrenheit: ");
            double c = (f - 32) * 5 / 9;
            System.out.println(f + " °F = " + c + " °C");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    //string conversions
    private static void convert(Scanner sc, String fromUnit, String toUnit, double factor) {
        double value = getDouble(sc, "Enter " + fromUnit + ": ");
        double result = value * factor;
        System.out.println(value + " " + fromUnit + " = " + result + " " + toUnit);
    }

    private static int getInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    private static double getDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }
}
