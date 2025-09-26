package JsonReader;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InvalidTest {

    @Test
    void testInvalid() {
        // Path to invalid JSON (already in resources)
        String filePath = "src/test/resources/invalid.json";

        // Execute method
        List<Map<String, Object>> result = JsonReader.readJson(filePath);

        // Print expected vs actual
        System.out.println("Test: Invalid JSON file");
        System.out.println("Expected: null");
        System.out.println("Actual: " + result);

        // Assert result is null
        assertNull(result, "Invalid JSON should return null");
    }
}
