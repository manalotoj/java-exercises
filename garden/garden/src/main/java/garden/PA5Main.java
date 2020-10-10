package garden;

/**
 * Hello world!
 *
 */
public class PA5Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Garden g = new Garden();
        g.grow(10);

        Plant f = new Flower("Rose");
        System.out.println(f.toString());
    }
}
