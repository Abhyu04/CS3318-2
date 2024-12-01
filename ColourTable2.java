import java.util.HashSet;

public class ColourTable {
    private int paletteSize;
    private HashSet<String> palette;

    public ColourTable(int paletteSize) {
        if (paletteSize < 2 || paletteSize > 1024 || (paletteSize & (paletteSize - 1)) != 0) {
            throw new IllegalArgumentException("Invalid palette size");
        }
        this.paletteSize = paletteSize;
        this.palette = new HashSet<>();
    }

    public void add(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException("Invalid color values");
        }
        String hexString = String.format("%02X%02X%02X", red, green, blue);
        if (palette.size() >= paletteSize) {
            throw new IllegalStateException("Palette is full");
        }
        palette.add(hexString);
    }
}
