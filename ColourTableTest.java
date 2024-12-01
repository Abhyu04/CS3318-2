import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColourTableTest {

    @Test
    void testConstructorValidPaletteSize() {
        assertDoesNotThrow(() -> new ColourTable(4));
        assertDoesNotThrow(() -> new ColourTable(8));
    }

    @Test
    void testConstructorInvalidPaletteSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(0));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025));
    }
}
