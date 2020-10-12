package garden;

public class Tree extends Plant {
    
    public Tree(String type, Plot plot) {
        super(type, plot);
        plot.plot[4][2] = symbol;
    }

    public void grow(int amount) {
        super.grow(amount);

        int rowIndex = plot.plot[0].length - 1;
        for (int i = rowIndex; i > rowIndex - size; i--) {
            plot.plot[i-1][2] = symbol;
        }
    }
}
