@Test
void testAddValidRGBColor() {
    ColourTable table = new ColourTable(4);
    assertDoesNotThrow(() -> table.add(255, 0, 0)); // Red
    assertDoesNotThrow(() -> table.add(0, 255, 0)); // Green
}

@Test
void testAddInvalidRGBColor() {
    ColourTable table = new ColourTable(4);
    assertThrows(IllegalArgumentException.class, () -> table.add(-1, 0, 0)); // Negative value
    assertThrows(IllegalArgumentException.class, () -> table.add(256, 0, 0)); // Out of range
}

@Test
void testAddExceedsCapacity() {
    ColourTable table = new ColourTable(1);
    table.add(255, 0, 0);
    assertThrows(IllegalStateException.class, () -> table.add(0, 255, 0)); // Exceeds capacity
}
