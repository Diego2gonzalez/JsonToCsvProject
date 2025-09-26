package JsonReader;

import com.google.gson.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Utility class for reading JSON files and converting their content into a list of maps.
 * <p>
 * Supports both single JSON objects and arrays of JSON objects.
 * Returns null if the file cannot be read or the JSON format is invalid.
 * </p>
 */
public class JsonReader {

    /**
     * Reads a JSON file from the specified path and converts it into a list of maps.
     * <p>
     * - If the JSON is a single object, the list will contain one map.
     * - If the JSON is an array of objects, each element will be converted to a map.
     * - If the JSON is invalid or not an object/array, null is returned.
     * </p>
     *
     * @param filePath the path to the JSON file
     * @return a list of maps representing the JSON objects, or null if the file is invalid or cannot be read
     */
    public static List<Map<String, Object>> readJson(String filePath) {
        Gson gson = new Gson();

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            JsonElement element = JsonParser.parseReader(reader);

            List<Map<String, Object>> dataList = new ArrayList<>();

            if (element.isJsonObject()) {
                // Single JSON object
                Map<String, Object> map = gson.fromJson(element, Map.class);
                dataList.add(map);

            } else if (element.isJsonArray()) {
                // JSON array of objects
                JsonArray array = element.getAsJsonArray();
                for (JsonElement item : array) {
                    Map<String, Object> map = gson.fromJson(item, Map.class);
                    dataList.add(map);
                }
            } else {
                System.out.println("Invalid JSON: not an object or array of objects");
                return null;
            }

            return dataList;

        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.out.println("JSON file has invalid format: " + e.getMessage());
        }

        return null;
    }
}
