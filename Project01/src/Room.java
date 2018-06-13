import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Room
{

    final private int maxRoomIlluminance = 4000;
    final private int windowIlluminance = 700;
    final private double maxOccupiedSpace = 70.0;

    private String name;
    private int roomSpace;
    private int numberOfWindows;
    private int currentRoomIlluminance; // текущая освещенность
    private double currentOccupiedSpace;    // % занимаемого места
    private int maxSpaceUsage;
    private int minSpaceUsage;
    private List<Bulb> bulbList; // Коллекция ламп
    private List<Furniture> furnitureList; // Коллекция мебели

    public Room (String name, int roomSpace, int numberOfWindows) throws IlluminanceTooMuchException
    {
        if (numberOfWindows * windowIlluminance > maxRoomIlluminance)  // слишком много окон
        {
            throw new IlluminanceTooMuchException ();
        }
        this.name = name;
        this.roomSpace = roomSpace;
        this.numberOfWindows = numberOfWindows;
        currentRoomIlluminance += numberOfWindows*windowIlluminance; // к суммарной освещенности добавляем от окон
        bulbList = new ArrayList<>();
        furnitureList = new ArrayList<>();
    }

    public String getName ()
    {
        return name;
    }

    public void add (Bulb bulb) throws IlluminanceTooMuchException
    {
        if (currentRoomIlluminance + bulb.getBrightness() > maxRoomIlluminance) // не слишком ли много ламп
        {
            throw new IlluminanceTooMuchException ();
        }
        bulbList.add(bulb);
        currentRoomIlluminance += bulb.getBrightness();
    }

    public void add (Furniture customFurniture) throws SpaceUsageTooMuchException
    {
        if ((((double)maxSpaceUsage + customFurniture.getMaxSquare()) / roomSpace)*100 > maxOccupiedSpace ) // не слишком ли много мебели
        {
            throw new SpaceUsageTooMuchException ();
        }
        furnitureList.add(customFurniture);
        minSpaceUsage += customFurniture.getMinSquare();
        maxSpaceUsage += customFurniture.getMaxSquare();

        currentOccupiedSpace = 100 -((double)maxSpaceUsage / roomSpace*100); // % занимаемого пространства
    }

    public void describe()
    {
        NumberFormat formatter = new DecimalFormat("#0.00"); // чтобы привести % к формату
        System.out.println("\n" + name + "\n");
        System.out.print("Общая освещенность = " + currentRoomIlluminance);

        if (numberOfWindows==1)                                 //орфография окно\окна\окон
        {
            System.out.print(" ( " + numberOfWindows + " окно в 700 лк; Лампочки ");
        }
        if (numberOfWindows>=2&&numberOfWindows<=4)
        {
            System.out.print(" ( " + numberOfWindows + " окна в 700 лк; Лампочки ");
        }
        else
        {
            System.out.print(" ( " + numberOfWindows + " окон в 700 лк; Лампочки ");
        }

        for (Bulb b : bulbList)
        {
            System.out.print(b.getBrightness() + "; ");
        }
        System.out.println(")");
        System.out.print("Общая площадь комнаты = " + roomSpace + " м^2 ( используется " + minSpaceUsage + " - " + maxSpaceUsage + " м^2");
        System.out.println(", свободно " + (roomSpace - maxSpaceUsage) + " м^2 или " + formatter.format(currentOccupiedSpace) + "% от всего пространства комнаты)");
        System.out.println("Мебель :");
        if (furnitureList.size() == 0) {
            System.out.println("Нету мебели");
        } else {
            for (Furniture f : furnitureList) {
                f.describe();
            }
        }

    }
}