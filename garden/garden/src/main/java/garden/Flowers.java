package garden;

public enum Flowers 
{
    Rose("Rose"), 
    Lily("Lily"),
    Iris("Iris"),
    Daisy("Daisy"),
    Tulip("Tulip"),
    Sunflower("Sunflower");
 
    private String flower;
 
    Flowers(String flower) {
        this.flower = flower;
    }
 
    public String getFlower() {
        return flower;
    }

     static boolean isFlower(String flower) {
        try {
            Flowers.valueOf(flower);
            return true;
        } catch(Exception e) {
            return false;
        }
        finally {}
    }
}