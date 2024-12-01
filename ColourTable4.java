public void remove(int red, int green, int blue) {
    String hexString = String.format("%02X%02X%02X", red, green, blue);
    if (!palette.contains(hexString)) {
        throw new IllegalArgumentException("Color not in palette");
    }
    palette.remove(hexString);
}
