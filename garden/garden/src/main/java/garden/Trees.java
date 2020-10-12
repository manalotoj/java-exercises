package garden;

public enum Trees 
{
    Oak("Oak"), 
    Willow("Willow"),
    Banana("Banana"),
    Coconut("Coconut"),
    Pine("Pine");
 
    private String tree;
 
    Trees(String tree) {
        this.tree = tree;
    }
 
    public String getTree() {
        return tree;
    }

     static boolean isTree(String tree) {
        try {
            Trees.valueOf(tree);
            return true;
        } catch(Exception e) {
            return false;
        }
        finally {}
    }
}