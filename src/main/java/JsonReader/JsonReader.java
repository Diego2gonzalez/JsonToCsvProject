package JsonReader;

import com.google.gson.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonReader {

    public static List<Map<String, Object>> readJson(String filePath) {
        Gson gson = new Gson();

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            JsonElement element = JsonParser.parseReader(reader);

            List<Map<String, Object>> dataList = new ArrayList<>();

            if (element.isJsonObject()) {
                Map<String, Object> map = gson.fromJson(element, Map.class);
                dataList.add(map);

            } else if (element.isJsonArray()) {
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
