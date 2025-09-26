package JsonReader;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Utility class for writing a list of maps to a CSV file.
 * <p>
 * Each map represents a row in the CSV file, with the keys as column headers.
 * </p>
 */
public class CsvWriter {

    /**
     * Writes the given list of maps to a CSV file at the specified path.
     * <p>
     * - The keys of the first map are used as the CSV headers.
     * - Each map in the list represents a row in the CSV.
     * - Null values are converted to empty strings.
     * - If the list is null or empty, the method prints a message and does nothing.
     * </p>
     *
     * @param filePath the path where the CSV file will be saved
     * @param dataList the list of maps to write to the CSV file
     */
    public static void writeCsv(String filePath, List<Map<String, Object>> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            System.out.println("No data available to write to CSV.");
            return;
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

            // Write header using the keys of the first map
            String[] header = dataList.get(0).keySet().toArray(new String[0]);
            writer.writeNext(header);

            // Write rows
            for (Map<String, Object> row : dataList) {
                String[] line = row.values().stream()
                        .map(value -> value != null ? value.toString() : "")
                        .toArray(String[]::new);
                writer.writeNext(line);
            }

            System.out.println("CSV successfully generated at: " + filePath);

        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }
}
