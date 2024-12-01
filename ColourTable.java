public class ColourTable {
    private int paletteSize;

    public ColourTable(int paletteSize) {
        if (paletteSize < 2 || paletteSize > 1024 || (paletteSize & (paletteSize - 1)) != 0) {
            throw new IllegalArgumentException("Invalid palette size");
        }
        this.paletteSize = paletteSize;
    }
}
