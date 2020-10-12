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
        Garden g = new Garden(2, 1);
        System.out.println("Print empty 2x1 garden:");
        g.print();
        System.out.println();

        g = new Garden(2, 2);
        System.out.println("Print empty 2x2 garden:");
        g.print();
        System.out.println();

        g = new Garden(2, 3);
        System.out.println("Print empty 2x3 garden:");
        g.print();
        System.out.println();

        g = new Garden(1, 5);
        System.out.println("Print empty 1x5 garden:");
        g.print();
        System.out.println();

        Plot plot = new Plot();
        Plant p = new Flower("Rose", plot);
        System.out.println(p.toString());

        plot = new Plot();
        p = new Tree("Banana", plot);
        System.out.println(p.toString());
        p.grow(1);
        System.out.println(p.toString());
        p.grow(1);
        System.out.println(p.toString());
        p.grow(1);
        System.out.println(p.toString());
        p.grow(5);
        System.out.println(p.toString());
        System.out.println();

        // try enums
        Flowers rose = Flowers.Rose;
        System.out.println(rose);
        System.out.println();

        g = new Garden(1, 3);
        System.out.println("Print empty 1x3 garden");
        Plot bananaPlot = new Plot();
        Plant banana = new Tree("banana", bananaPlot);
        g.plant(0, 0, banana);
        System.out.println("Plant banana at 0,0");
        g.print();
        System.out.println();

        System.out.println("Plant rose at 0, 1");
        Plot rosePlot = new Plot();
        Plant rose2 = new Flower("Rose", rosePlot);
        g.plant(0, 1, rose2);
        g.print();

        System.out.println("Plant tomato at 0, 1");
        Plot tomatoPlot = new Plot();
        Plant tomato = new Flower("Iris", tomatoPlot);
        g.plant(0, 2, tomato);
        g.print();
    }
}
