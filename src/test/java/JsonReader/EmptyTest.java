package JsonReader;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EmptyTest {

    @Test
    void testReadEmptyJson() {
        String path = "src/test/resources/empty.json";
        Map<?, ?> result = JsonReader.readJson(path);
        assertNotNull(result, "El resultado no debería ser null");
        assertTrue(result.isEmpty(), "El Map debería estar vacío");
    }

}
