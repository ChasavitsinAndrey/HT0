

public class Program {

    public static void main (String[] args) throws IlluminanceTooMuchException, SpaceUsageTooMuchException {

        Building building = new Building("Ратуша");

        building.add(new Room("Гостинная", 1000, 3));
        building.add(new Room("Подвал", 500, 2));
        building.add(new Room("Туалет", 700, 5));
        building.add(new Room("Кабинет_1", 900, 4));

        building.getRoom("Гостинная").add(new Bulb(100));
        building.getRoom("Гостинная").add(new Bulb(50));
        building.getRoom("Гостинная").add(new Table("Компьютерный стол", 4));
        building.getRoom("Гостинная").add(new Chair("Офисное кресло", 4, 5));

        building.getRoom("Подвал").add(new Bulb(80));
        building.getRoom("Подвал").add(new Bulb(80));
        building.getRoom("Подвал").add(new Table("Офисный стол", 3));
        building.getRoom("Подвал").add(new Chair("Массажное кресло", 4, 5));

        building.getRoom("Туалет").add(new Bulb(70));
        building.getRoom("Туалет").add(new Bulb(240));
        building.getRoom("Туалет").add(new Bulb(80));
        
        //building.getRoom("Туалет").add(new Bulb(500));  // провверка на IlluminanceToMuchException

        building.getRoom("Кабинет_1").add(new Bulb(70));
        building.getRoom("Кабинет_1").add(new Bulb(240));
        building.getRoom("Кабинет_1").add(new Bulb(80));
        building.getRoom("Кабинет_1").add(new Table("Компьютерный стол", 3));
        building.getRoom("Кабинет_1").add(new Table("Офисный стол", 6));
        building.getRoom("Кабинет_1").add(new Chair("Массажное кресло", 5, 6));

        //building.getRoom("Кабинет_1").add(new Table("Мегастол", 800)); // провверка на SpaceUsageToMuchException

        building.describe();
    }
}