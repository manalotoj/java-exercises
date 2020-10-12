package garden;

public class Garden {

    private final Plot[][] garden;
    private final int rowSize;
    private final int colSize;

    public Garden(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        garden = new Plot[rowSize][colSize];
        initialize(rowSize, colSize);
    }

    public void plant(int row, int col, Plant plant) {
        garden[row][col] = plant.plot;
    }

    public void grow(int amount) {
        System.out.println( "grow");
    }

    private void initialize(int rowSize, int colSize) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                garden[i][j] = new Plot();
            }
        }
    }

    public void grow(int amount, int row, int col) {

    }

    public void grow(int amount, String plantType) {

    }

    public void harvest() {

    }

    public void harvest(int row, int col) {

    }

    public void harvest(String plantType) {

    }

    public void pick(int row, int col) {

    }

    public void pick(String plantType) {

    }

    public void cut(int row, int col) {

    }

    public void cut(String plantType) {    
    }

    public void print() {
        String[][] arrayForPrint = new String[rowSize * Plot.rowSize][colSize * Plot.colSize];    
        
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                
                copyArray(garden[i][j].plot, arrayForPrint, i * Plot.rowSize, j * Plot.colSize);
            }
        }

        for (int i = 0; i < rowSize * Plot.rowSize; i++) {
            System.out.println(String.join("", arrayForPrint[i]));
        }
    }

    private void copyArray(String[][] source, String[][] target, int rowStart, int colStart) {
        for (int i = 0; i < Plot.rowSize; i++) {
            for (int j = 0; j < Plot.colSize; j++) {
                target[i + rowStart][j + colStart] = source[i][j];
            }
        }
    }
}
