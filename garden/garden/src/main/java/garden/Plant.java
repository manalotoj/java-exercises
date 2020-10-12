package garden;

public class Plant {
    protected Plot plot;
    protected String type;
    protected int size;
    final int maxSize = 3;
    final int maxRow = 5;
    final int maxCol = 5;
    final String symbol;

    public Plant(String type, Plot plot) {
        this.type = type;
        this.plot = plot;
        symbol = getSymbol();
        size = 0;
    }

    // <getters>
    public Plot getPlot() {
        return plot;
    }
    // </getters>

    protected String getSymbol() {
        return type.substring(0,1).toLowerCase();
    }

    public void grow(int amount) {
        if (size == maxSize) {
            // can't grow any more
            return;
        }

        if (amount + size < maxSize) {
            size += amount;
        } else {
            size = maxSize;
        }
    }

    public String toString() {
        String result = "";
        for (int outer = 0; outer < 5; outer++) {
            for (int inner = 0; inner < 5; inner++) {
                result += plot.plot[outer][inner];
            }            
        }
        return result;
    }
}
