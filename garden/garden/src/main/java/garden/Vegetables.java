package garden;

public enum Vegetables 
{
    garlic("garlic"), 
    zucchini("zucchini"),
    tomato("tomato"),
    yam("yam"),
    lettuce("lettuce");
 
    private String vegetable;
 
    Vegetables(String vegetable) {
        this.vegetable = vegetable;
    }
 
    public String getVegetable() {
        return vegetable;
    }

     static boolean isVegetable(String vegetable) {
        try {
            Vegetables.valueOf(vegetable);
            return true;
        } catch(Exception e) {
            return false;
        }
        finally {}
    }
}