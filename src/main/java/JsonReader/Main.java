package JsonReader;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class for a console application that allows users to:
 * 1. Read a JSON file and print its content in the terminal.
 * 2. Convert a JSON file to a CSV file.
 * 3. Exit the program.
 *
 * <p>
 * This class provides a simple menu-driven interface for JSON file operations.
 * </p>
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Entry point of the application.
     * <p>
     * Displays a menu and executes user-selected options until the user chooses to exit.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int option;
        do {
            showMenu();
            option = readOption();

            switch (option) {
                case 1:
                    readAndPrintJson();
                    break;
                case 2:
                    convertJsonToCsv();
                    break;
                case 3:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (option != 3);
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void showMenu() {
        System.out.println("\n     MENU");
        System.out.println("1. Read JSON and print in terminal");
        System.out.println("2. Convert JSON to CSV");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
    }

    /**
     * Reads a numeric option from the user.
     * <p>
     * Ensures that the input is a valid integer. Prompts repeatedly until a valid number is entered.
     * </p>
     *
     * @return the user-selected option as an integer
     */
    private static int readOption() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Prompts the user for a JSON file path, reads the JSON content using JsonReader,
     * and prints it in a readable format in the terminal.
     */
    private static void readAndPrintJson() {
        System.out.print("Enter the JSON file path: ");
        scanner.nextLine(); // clear buffer
        String jsonPath = scanner.nextLine();

        List<Map<String, Object>> dataList = JsonReader.readJson(jsonPath);

        if (dataList != null) {
            System.out.println("\nJSON content:");
            for (Map<String, Object> map : dataList) {
                System.out.println("------------------");
                map.forEach((key, value) -> System.out.println(key + " : " + value));
            }
        } else {
            System.out.println("Failed to read JSON.");
        }
    }

    /**
     * Prompts the user for a JSON file path and a target CSV file path,
     * reads the JSON content, and writes it as a CSV file using CsvWriter.
     */
    private static void convertJsonToCsv() {
        System.out.print("Enter the JSON file path: ");
        scanner.nextLine(); // clear buffer
        String jsonPath = scanner.nextLine();

        System.out.print("Enter the CSV file path to save: ");
        String csvPath = scanner.nextLine();

        List<Map<String, Object>> dataList = JsonReader.readJson(jsonPath);

        if (dataList != null) {
            CsvWriter.writeCsv(csvPath, dataList);
        } else {
            System.out.println("Failed to read JSON.");
        }
    }
}
