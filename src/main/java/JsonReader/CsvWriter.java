package JsonReader;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * CsvWriter is a utility class that writes JSON data to a CSV file.
 * Uses OpenCSV to create the CSV file.
 */
public class CsvWriter {

    /**
     * Writes data to a CSV file.
     *
     * @param filePath the full path of the CSV file to create
     * @param data     the data to write (Map)
     * @throws IllegalArgumentException if data is null, not a Map, or contains null rows
     */
    public static void writeCsv(String filePath, Object data) {
        if (data == null) {
            throw new IllegalArgumentException("Data to write cannot be null");
        }

        List<Map<String, Object>> dataList = new ArrayList<>();

        if (data instanceof Map) {
            dataList.add((Map<String, Object>) data);
        } else if (data instanceof List) {
            dataList = (List<Map<String, Object>>) data;
        } else {
            throw new IllegalArgumentException("Invalid data type for writing CSV");
        }

        if (dataList.isEmpty()) {
            System.out.println("No data to write to CSV.");
            return;
        }
        for (Map<String, Object> row : dataList) {
            if (row == null) {
                throw new IllegalArgumentException("One of the JSON rows is null");
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] header = dataList.get(0).keySet().toArray(new String[0]);
            writer.writeNext(header);
            for (Map<String, Object> row : dataList) {
                String[] line = row.values().stream()
                        .map(value -> value != null ? value.toString() : "")
                        .toArray(String[]::new);
                writer.writeNext(line);
            }
            System.out.println("CSV file created at: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }

    /**
     * Main method to run CsvWriter.
     * Reads a JSON file and writes it to a CSV file.
     *
     */
    public static void main(String[] args) {
        String jsonPath = "src/test/resources/user.json";
        String csvPath = "src/test/resources/user.csv";
        Map<?, ?> userData = JsonReader.readJson(jsonPath);
        if (userData != null) {
            System.out.println("JSON read successfully.");
            writeCsv(csvPath, userData);
        } else {
            System.out.println("Could not read the JSON file.");
        }
    }
}
