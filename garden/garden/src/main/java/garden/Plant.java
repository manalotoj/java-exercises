package garden;

public class Plant {
    protected String[][] plot;
    protected String type;
    protected int size;
    final int maxSize = 4;

    public Plant(String type) {
        this.type = type;
        size = 0;        
    }

    protected String getSymbol() {
        return type.substring(0,1).toLowerCase();
    }

    public void print() {}
    public void grow(int amount) {
        if (amount + size < maxSize) {
            size += amount;
        } else {
            size = maxSize;
        }
    }

    public void clear() {
        size = 0;
        plot = new String[][] {
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",".",".","."}
        };
    }

    public String toString() {
        String result = "";
        for (int outer = 0; outer < 5; outer++) {
            for (int inner = 0; inner < 5; inner++) {
                result += plot[outer][inner];
            }            
        }
        return result;
    }
}
