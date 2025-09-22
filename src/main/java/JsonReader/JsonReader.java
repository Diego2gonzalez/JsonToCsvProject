package JsonReader;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Utility class to read JSON files into a Map.
 */
public class JsonReader {

    /**
     * Reads a JSON file.
     *
     * @param filePath the full path of the JSON file
     * @return a Map representing the JSON content, or null if an error occurs
     */
    public static Map<?, ?> readJson(String filePath) {
        Gson gson = new Gson();
        try (Reader myReader = Files.newBufferedReader(Paths.get(filePath))) {
            return gson.fromJson(myReader, Map.class);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.out.println("The JSON file is not valid: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("The JSON is empty or badly formatted.");
        }
        return null; // return null in case of error
    }

    /**
     * Main method to run JsonReader.
     *
     */
    public static void main(String[] args) {
        String path = "src/test/resources/user.json"; // Change to your JSON file path
        Map<?, ?> userData = readJson(path);
        if (userData != null) {
            System.out.println("JSON content:");
            for (Entry<?, ?> entry : userData.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } else {
            System.out.println("Could not read the JSON file.");
        }
    }
}
