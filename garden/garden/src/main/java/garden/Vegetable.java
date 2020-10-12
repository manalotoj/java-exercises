package garden;

public class Vegetable extends Plant {

    public Vegetable(String type, Plot plot) {
        super(type, plot);
        plot.plot[0][2] = symbol;
    }

    protected int getMaxSize() {
        return 4;
    }

    public void grow(int amount) {
        super.grow(amount);
        
        for (int i = 0; i <= size; i++) {
            plot.plot[i][2] = symbol;
        }
    }
}
