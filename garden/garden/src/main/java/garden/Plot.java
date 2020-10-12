package garden;

public class Plot {
    protected String[][] plot;
    public Plant plant;
    public final static int rowSize = 5;
    public final static int colSize = 5;

    public Plot() {
        initialize();
    }

    public String[][] getPlot() {
        return plot;
    }

    public void plant(Plant plant) {
        this.plant = plant;
    }

    public void clear() {
        plant = null;
        initialize();
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
