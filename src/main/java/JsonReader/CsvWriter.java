package JsonReader;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvWriter {

    public static void writeCsv(String filePath, List<Map<String, Object>> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            System.out.println("No data available to write to CSV.");
            return;
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

            // Header
            String[] header = dataList.get(0).keySet().toArray(new String[0]);
            writer.writeNext(header);

            // Rows
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
