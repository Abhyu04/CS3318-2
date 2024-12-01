import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColourTableTest {

    // Test valid palette sizes
    @Test
    void testConstructorValidPaletteSize() {
        assertDoesNotThrow(() -> new ColourTable(4));
        assertDoesNotThrow(() -> new ColourTable(8));
    }

    // Test invalid palette sizes
    @Test
    void testConstructorInvalidPaletteSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(0));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025));
    }

    // Test adding valid RGB colors
    @Test
    void testAddValidRGBColor() {
        ColourTable table = new ColourTable(4);
        assertDoesNotThrow(() -> table.add(255, 0, 0)); // Red
        assertDoesNotThrow(() -> table.add(0, 255, 0)); // Green
        assertEquals(2, table.countColors()); // Verify count
    }

    // Test adding invalid RGB colors
    @Test
    void testAddInvalidRGBColor() {
        ColourTable table = new ColourTable(4);
        assertThrows(IllegalArgumentException.class, () -> table.add(-1, 0, 0)); // Negative value
        assertThrows(IllegalArgumentException.class, () -> table.add(256, 0, 0)); // Out of range
    }

    // Test adding colors exceeding the palette size
    @Test
    void testAddExceedsCapacity() {
        ColourTable table = new ColourTable(1);
        table.add(255, 0, 0);
        assertThrows(IllegalStateException.class, () -> table.add(0, 255, 0)); // Exceeds capacity
    }

    // Test removing valid RGB colors
    @Test
    void testRemoveValidRGBColor() {
        ColourTable table = new ColourTable(4);
        table.add(255, 255, 255); // White
        assertDoesNotThrow(() -> table.remove(255, 255, 255));
        assertEquals(0, table.countColors()); // Verify count
    }

    // Test removing a color not in the palette
    @Test
    void testRemoveNonExistentColor() {
        ColourTable table = new ColourTable(4);
        assertThrows(IllegalArgumentException.class, () -> table.remove(255, 255, 255)); // Not in palette
    }

    // Test counting the colors in the palette
    @Test
    void testCountColors() {
        ColourTable table = new ColourTable(4);
        assertEquals(0, table.countColors()); // Initially empty
        table.add(255, 0, 0);
        assertEquals(1, table.countColors()); // After adding one color
    }
}
