@Test
void testRemoveValidRGBColor() {
    ColourTable table = new ColourTable(4);
    table.add(255, 255, 255); // White
    assertDoesNotThrow(() -> table.remove(255, 255, 255));
}

@Test
void testRemoveNonExistentColor() {
    ColourTable table = new ColourTable(4);
    assertThrows(IllegalArgumentException.class, () -> table.remove(255, 255, 255)); // Not in palette
}
