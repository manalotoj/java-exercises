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

    public void plant(int row, int col, String plantType) {
        Plot plot = garden[row][col];
        Plant plant;
        if (Flowers.isFlower(plantType)) {
            plant = new Flower(plantType, plot);
            plot.plant(plant);
        } else if (Vegetables.isVegetable(plantType)) {
            plant = new Vegetable(plantType, garden[row][col]);
            plot.plant(plant);  
        } else if (Trees.isTree(plantType)) {
            plant = new Tree(plantType, plot);
            plot.plant(plant);  
        }
    }

    private void initialize(int rowSize, int colSize) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                garden[i][j] = new Plot();
            }
        }
    }

    public void grow() {
        grow(1);
    }

    public void grow(int amount) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                Plant plant = garden[i][j].plant;
                if (plant != null) {
                    plant.grow(amount);
                }
            }
        }
    }

    public void grow(int amount, int row, int col) {
        Plant plant = garden[row][col].plant;
        if (plant != null) {
            plant.grow(amount);
        }
    }

    public void growPlantClass(int amount, String plantClass) {
        IPlotVoidOperator growPlantClass = (plot) -> {
            Plant plant = plot.plant;
            if (plant != null && 
                plant.getClass().toString().toLowerCase().contains(plantClass.toLowerCase())) {
                plant.grow(amount);
            }
        };

        applyToGarden(growPlantClass);
    }

    public void growPlantType(int amount, String plantType) {
        IPlotVoidOperator pickFlowers = (plot) -> {
            Plant plant = plot.plant;
            if (plant != null && 
                plant.type.toLowerCase().equals(plantType.toLowerCase())) {
                plant.grow(amount);
            }
        };

        applyToGarden(pickFlowers);
    }

    public void harvest() {
        IPlotVoidOperator harvestVegetables = (plot) -> {
            Plant plant = plot.plant;
            if (plant != null && 
                plant instanceof Vegetable) {
                plot.clear();
            }
        };

        applyToGarden(harvestVegetables);        
    }

    public void harvest(int row, int col) {
        Plant plant = garden[row][col].plant;
        if (plant != null && plant instanceof Vegetable) {
            garden[row][col].clear();
        }
    }

    public void harvest(String plantType) {
        IPlotVoidOperator harvestVegetableOfType = (plot) -> {
            Plant plant = plot.plant;
            if (plant != null && 
                plant instanceof Vegetable &&
                plant.type.toLowerCase().equals(plantType.toLowerCase())) {
                plot.clear();
            }
        };

        applyToGarden(harvestVegetableOfType);
    }

    public void pick() {
        IPlotVoidOperator pickFlowers = (plot) -> {
            Plant plant = plot.plant;
            if (plant != null && 
                plant instanceof Flower) {
                plot.clear();
            }
        };

        applyToGarden(pickFlowers);
    }

    public void pick(int row, int col) {
        Plant plant = garden[row][col].plant;
        if (plant != null && plant instanceof Flower) {
            garden[row][col].clear();
        }
    }

    public void pick(String plantType) {
        IPlotVoidOperator pickFlowerOfType = (plot) -> {
            Plant plant = plot.plant;
            if (plant != null && 
                plant instanceof Flower &&
                plant.type.toLowerCase().equals(plantType.toLowerCase())) {
                plot.clear();
            }
        };

        applyToGarden(pickFlowerOfType);
    }
    public void cut() {
        IPlotVoidOperator cutTrees = (plot) -> {
            Plant plant = plot.plant;
            if (plant != null && 
                plant instanceof Tree) {
                plot.clear();
            }
        };

        applyToGarden(cutTrees);
    }

    public void cut(int row, int col) {
        Plant plant = garden[row][col].plant;
        if (plant != null && plant instanceof Tree) {
            garden[row][col].clear();
        }
    }

    public void cut(String plantType) {
        IPlotVoidOperator cutTreesOfType = (plot) -> {
            Plant plant = plot.plant;
            if (plant != null && 
                plant instanceof Tree &&
                plant.type.toLowerCase().equals(plantType.toLowerCase())) {
                plot.clear();
            }
        };

        applyToGarden(cutTreesOfType);
    }

    private void applyToGarden(IPlotVoidOperator operator) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                operator.operation(garden[i][j]);
            }
        }
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
