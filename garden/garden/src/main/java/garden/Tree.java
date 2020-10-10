package garden;

public class Tree extends Plant {
    
    public Tree(String type) {
        super(type);
        plot = new String[][] {
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",symbol,".","."}
        };
    }

    public void grow(int amount) {
        super.grow(amount);

        int rowIndex = plot[0].length - 1;
        for (int i = rowIndex; i > rowIndex - size; i--) {
            plot[i-1][2] = symbol;
        }
    }
}
