package garden;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.javatuples.Pair;

public class PA5Main 
{
    static Garden garden;
    static int rows;
    static int cols;

    public static void main( String[] args ) {
        if (args.length == 0) return;
        
        String filePath = args[0];

        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			while (line != null) {
                //System.out.println(line);
                if (line.contains("rows")) {
                    String colsLine = reader.readLine();
                    createGarden(line, colsLine);
                } else if(line.equals("")) {
                    // do nothing
                } else {
                    processGardenCommand(line);
                }
                // read next line
                line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    private static void createGarden(String rowsLine, String colsLine) {
        rows =  Integer.parseInt(rowsLine.split(":")[1].trim());
        cols = Integer.parseInt(colsLine.split(":")[1].trim());
        garden = new Garden(rows, cols);
    }

    private static void processGardenCommand(String line) {
        String[] lineParts = line.split(" ");
        String cmd = lineParts[0].toLowerCase();

        printCommand(cmd, lineParts);

        switch(cmd) {
            case "plant":
                //System.out.println("is flower: " + Flowers.isFlower(lineParts[2]));
                Pair<Integer, Integer> coords = parseCoordinates(lineParts[1]);
                String plantType = lineParts[2].toLowerCase();
                //System.out.println("Line Parts: " + lineParts[2]);
                garden.plant(coords.getValue0(), coords.getValue1(), plantType);
                break;

            case "grow":
                processGrow(lineParts);
                break;

            case "harvest":
                processHarvest(lineParts);            
                break;

            case "cut":
                processCut(lineParts);
                break;

            case "pick":
                processPick(lineParts);
                break;

            case "print":
                garden.print();
                break;
        }
    }

    private static void printCommand(String cmd, String[] lineParts) {
        if (cmd.equals("plant")) return;
        
        for (int i = 0; i < lineParts.length; i++) {
            if (i == 0) {
                System.out.print(lineParts[i].toUpperCase());
            } else {
                System.out.print(" " + lineParts[i]);
            }
        }
        
        System.out.print("\n");
        if (!cmd.equals("print")) {
            System.out.print("\n");
        }
    }

    private static void processPick(String[] lineParts) {
        if (lineParts.length == 1) {
            garden.pick();
        } else {
            if (lineParts[1].contains("(")) {
                Pair<Integer, Integer> coords = parseCoordinates(lineParts[1]);
                garden.pick(coords.getValue0(), coords.getValue1());
            } else {
                garden.pick(lineParts[1]);
            }
        }
    }

    private static void processCut(String[] lineParts) {
        if (lineParts.length == 1) {
            garden.cut();
        } else {
            if (lineParts[1].contains("(")) {
                Pair<Integer, Integer> coords = parseCoordinates(lineParts[1]);
                garden.cut(coords.getValue0(), coords.getValue1());
            } else {
                garden.cut(lineParts[1]);
            }
        }
    }

    private static void processHarvest(String[] lineParts) {
        if (lineParts.length == 1) {
            garden.harvest();
        } else {
            if (lineParts[1].contains("(")) {
                Pair<Integer, Integer> coords = parseCoordinates(lineParts[1]);
                garden.harvest(coords.getValue0(), coords.getValue1());
            } else {
                garden.harvest(lineParts[1]);
            }
        }
    }

    private static void processGrow(String[] lineParts) {
        switch(lineParts.length) {
            case 1:
                garden.grow();
                break;

            case 2:
                Integer amount = Integer.parseInt(lineParts[1]);
                garden.grow(amount);
                break;

            case 3:
                Integer amount1 = Integer.parseInt(lineParts[1]);
                if (lineParts[2].contains("(")) {
                    // grow 1 (x,y)
                    Pair<Integer, Integer> coords = parseCoordinates(lineParts[2]);
                    garden.grow(amount1, coords.getValue0(), coords.getValue1());
                } else {
                    // grow 1 plantType
                    String plantTypeOrClass = lineParts[2];
                    switch(plantTypeOrClass) {
                        case "vegetable":
                        case "tree":
                        case "flower":
                            garden.growPlantClass(amount1, plantTypeOrClass);
                            break;
                        default:
                            garden.growPlantType(amount1, plantTypeOrClass);
                            break;
                    }
                }
                break;

            default:
                break;
        }
    }

    private static Pair<Integer, Integer> parseCoordinates(String coords) {
        //System.out.println("coords: " + coords);
        coords = coords.replace("(", "").replace(")", "");
        String[] coorsParts = coords.split(",");
        return new Pair<>(Integer.parseInt(coorsParts[0]), Integer.parseInt(coorsParts[1]));
    }

    private static void RunTests() {
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
        Flowers rose = Flowers.rose;
        System.out.println(rose);
        System.out.println();

        g = new Garden(1, 3);
        System.out.println("Print empty 1x3 garden");
        g.print();
        g.plant(0, 0, "Banana");
        System.out.println("Plant banana at 0,0");
        g.print();
        System.out.println();

        System.out.println("Plant rose at 0, 1");
        g.plant(0, 1, "Rose");
        g.print();

        System.out.println("Plant tomato at 0, 1");
        g.plant(0, 2, "Tomato");
        g.print();

        System.out.println("Grow garden 1");
        g.grow(1);
        g.print();

        System.out.println("Grow garden 1");
        g.grow(1);
        g.print();

        System.out.println("Grow garden 1");
        g.grow(1);
        g.print();

        System.out.println("Grow Trees and Vegetables 5");
        g.growPlantClass(5, "Tree");
        g.growPlantClass(5, "Vegetable");
        g.print();

        System.out.println("Cut garden oak trees");
        g.cut("Oak");
        g.print();

        System.out.println("Cut garden banana trees");
        g.cut("Banana");
        g.print();

        System.out.println("Pick garden roses");
        g.pick("Rose");
        g.print();
    }
}
