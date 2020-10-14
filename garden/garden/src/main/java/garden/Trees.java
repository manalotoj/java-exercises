package garden;

public enum Trees 
{
    oak("oak"), 
    willow("willow"),
    banana("banana"),
    coconut("coconut"),
    pine("pine");
 
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