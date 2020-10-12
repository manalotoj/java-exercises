package garden;

public class Plot {
    protected String[][] plot;
    public Plant plant;
    protected int size;
    private final int maxSize = 4;
    public final static int rowSize = 5;
    public final static int colSize = 5;

    public Plot() {
        size = 0;
        initialize();
    }

    public String[][] getPlot() {
        return plot;
    }

    public void plant(Plant plant) {
        this.plant = plant;
    }

    public void grow() {
        // call plant.grow(...) and pass in plot
    }

    public void harvest() {
        size = 0;
        plot = new String[][] {
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",".",".","."}
        };
    }

    private void initialize() {
        plot = new String[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                plot[i][j] = ".";
            }
        }
    }
}
