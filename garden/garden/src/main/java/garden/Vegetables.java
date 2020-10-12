package garden;

public enum Vegetables 
{
    Garlic("Garlic"), 
    Zucchini("Zucchini"),
    Tomato("Tomato"),
    Yam("Yam"),
    Lettuce("Lettuce");
 
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