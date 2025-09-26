package JsonReader;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for testing the behavior of JsonReader when reading an empty JSON file.
 * <p>
 * This test verifies that reading an empty JSON file returns null.
 * </p>
 */
public class EmptyTest {

    /**
     * Tests the readJson method with an empty JSON file.
     * <p>
     * It expects the method to return null when the JSON file has no content.
     * </p>
     */
    void testEmpty() {
        // Path to the empty JSON file
        String filePath = "src/test/resources/empty.json";

        // Execute the method
        List<Map<String, Object>> result = JsonReader.readJson(filePath);

        // Print expected vs actual results
        System.out.println("Test: Empty JSON file");
        System.out.println("Expected: null");
        System.out.println("Actual: " + result);

        // Assert that the result is null
        assertNull(result, "Empty JSON should return null");
    }
}
