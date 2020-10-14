package garden;

public enum Flowers 
{
    rose("rose"), 
    lily("lily"),
    iris("iris"),
    daisy("daisy"),
    tulip("tulip"),
    sunflower("sunflower");
 
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