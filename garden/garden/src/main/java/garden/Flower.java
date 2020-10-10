package garden;

public class Flower extends Plant {

    public Flower(String type) {
        super(type);
        plot = new String[][] {
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",symbol,".","."},
            {".",".",".",".","."},
            {".",".",".",".","."}
        };
    }

    public void grow(int amount) {
        super.grow(amount);
        
        // single character makes it easier to visualize
        String s = symbol;
        switch(size) {
            case 1:
                // do nothing
                plot = new String[][]{
                    {".",".",".",".","."},
                    {".",".",  s,".","."},
                    {".",  s,  s,  s,"."},
                    {".",".",  s,".","."},
                    {".",".",".",".","."}
                };
                break;
            case 2:
                //TODO: fix me
                plot = new String[][]{
                    {".",".",".",".","."},
                    {".",".",  s,".","."},
                    {".",  s,  s,  s,"."},
                    {".",".",  s,".","."},
                    {".",".",".",".","."}
                };
                break;
            case 3:
                //TODO: fix me
                plot = new String[][]{
                    {".",".",".",".","."},
                    {".",".",  s,".","."},
                    {".",  s,  s,  s,"."},
                    {".",".",  s,".","."},
                    {".",".",".",".","."}
                };
                break;
            case 4:
                //TODO: fix me
                plot = new String[][]{
                    {".",".",".",".","."},
                    {".",".",  s,".","."},
                    {".",  s,  s,  s,"."},
                    {".",".",  s,".","."},
                    {".",".",".",".","."}
                };
                break;
            default:
                // do nothing
                break;
        }
    }
}
