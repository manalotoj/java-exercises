package garden;

public class Flower extends Plant {

    public Flower(String type, Plot plot) {
        super(type, plot);
        plot.plot[2][2] = symbol;
    }

    protected int getMaxSize() {
        return 3;
    }

    public void grow(int amount) {
        super.grow(amount);
        
        // single character makes it easier to visualize
        String s = symbol;
        switch(size) {
            case 1:
                plot.plot = new String[][]{
                    {".",".",".",".","."},
                    {".",".",  s,".","."},
                    {".",  s,  s,  s,"."},
                    {".",".",  s,".","."},
                    {".",".",".",".","."}
                };
                break;
            case 2:
                plot.plot = new String[][]{
                    {".",".",  s,".","."},
                    {".",  s,  s,  s,"."},
                    {  s,  s,  s,  s,  s},
                    {".",  s,  s,  s,"."},
                    {".",".",  s,".","."}
                };
                break;
            case 3:
                plot.plot = new String[][]{
                    {".",  s,  s,  s,"."},
                    {  s,  s,  s,  s,  s},
                    {  s,  s,  s,  s,  s},
                    {  s,  s,  s,  s,  s},
                    {".",  s,  s,  s,"."}
                };
                break;
            case 4:
                plot.plot = new String[][]{
                    {s,s,s,s,s},
                    {s,s,s,s,s},
                    {s,s,s,s,s},
                    {s,s,s,s,s},
                    {s,s,s,s,s}
                };
                break;
            default:
                // do nothing
                break;
        }
    }
}
