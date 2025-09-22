package JsonReader;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class InvalidTest {

    @Test
    void testReadInvalidJson() {
        String path = "src/test/resources/invalid.json";
        Map<?, ?> result = JsonReader.readJson(path);
        assertNull(result, "Result has to be NULL if Json is invalid");
    }
}
