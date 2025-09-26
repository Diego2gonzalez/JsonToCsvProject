package JsonReader;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

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

    private static void showMenu() {
        System.out.println("\n     MENU");
        System.out.println("1. Read JSON and print in terminal");
        System.out.println("2. Convert JSON to CSV");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
    }

    private static int readOption() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

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
