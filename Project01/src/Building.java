import java.util.ArrayList;
import java.util.List;

public class Building
{

    private String buildingName;
    private List<Room> rooms;

    public Building(String name)
    {
        buildingName = name;
        rooms = new ArrayList<>();
    }

    public void add(Room roomToAdd)             //  добавить комнату
    {
        if (rooms.size() == 0)
        {
            rooms.add(roomToAdd);
        }
        else
        {
            boolean roomExists = false;             // есть ли такая комната при добавлении
            for (Room room : rooms)
            {
                if (roomToAdd.getName().equals(room.getName()))
                {
                    roomExists = true;
                    break;
                }
            }
            if (roomExists)
            {
                System.out.println("Комната: " + roomToAdd.getName() + " уже существует!");
            }
            else
            {
                rooms.add(roomToAdd);
            }
        }
    }

    public Room getRoom(String name)
    {
        if (rooms.size() == 0)
        {
            System.out.println("В здании: " + buildingName +" нету ни одной комнаты!");
        }
        else
        {
            Room roomToFind = null;
            for (Room room : rooms)
            {
                if (room.getName().equals(name))
                {
                    roomToFind = room;
                    break;
                }
            }
            if (roomToFind == null)
            {
                System.out.println("Комната \"" + name + "\" не найдена.");
            }
            return roomToFind;
        }
        return null;
    }

    public void describe()
    {
        System.out.println(buildingName);
        for (Room r : rooms)
        {
            r.describe();
        }
    }
}