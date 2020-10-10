package garden;

public class Flower extends Plant {

    public Flower(String type) {
        super(type);
        plot = new String[][] {
            {".",".",".",".","."},
            {".",".",".",".","."},
            {".",".",getSymbol(),".","."},
            {".",".",".",".","."},
            {".",".",".",".","."}
        };
    }

    public void grow(int amount) {
        super.grow(amount);
        
        String s = getSymbol();
        switch(size) {
            case 0:
                // do nothing
                plot = new String[][]{
                    {".",".",".",".","."},
                    {".",".",  s,".","."},
                    {".",  s,  s,  s,"."},
                    {".",".",  s,".","."},
                    {".",".",".",".","."}
                };
                break;
            case 1:
                //TODO: fix me
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
            default:
                // do nothing
                break;
        }
    }
}
