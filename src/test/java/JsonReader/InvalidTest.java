package JsonReader;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for testing the behavior of JsonReader when reading an invalid JSON file.
 * <p>
 * This test verifies that reading a JSON file with invalid content returns null.
 * </p>
 */
public class InvalidTest {

    /**
     * Tests the readJson method with an invalid JSON file.
     * <p>
     * It expects the method to return null when the JSON content is malformed or cannot be parsed.
     * </p>
     */
    @Test
    void testInvalid() {
        // Path to the invalid JSON file
        String filePath = "src/test/resources/invalid.json";

        // Execute the method
        List<Map<String, Object>> result = JsonReader.readJson(filePath);

        // Print expected vs actual results
        System.out.println("Test: Invalid JSON file");
        System.out.println("Expected: null");
        System.out.println("Actual: " + result);

        // Assert that the result is null
        assertNull(result, "Invalid JSON should return null");
    }
}
