package garden;

public class Plant {
    protected Plot plot;
    protected String type;
    protected int size;
    final int maxRow = 5;
    final int maxCol = 5;
    protected final String symbol;

    public Plant(String type, Plot plot) {
        this.type = type;
        this.plot = plot;
        symbol = getSymbol();
        size = 0;
    }

    protected int getMaxSize() {
        return 3;
    }

    // <getters>
    public Plot getPlot() {
        return plot;
    }
    // </getters>

    protected String getSymbol() {
        return type.substring(0,1).toLowerCase();
    }

    public void grow() {
        grow(1);
    }

    public void grow(int amount) {
        if (size == getMaxSize()) {
            // can't grow any more
            return;
        }

        if (amount + size < getMaxSize()) {
            size += amount;
        } else {
            size = getMaxSize();
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
