public class Table extends Furniture
{

    public Table(String name, int square)
    {
        super(name, square, square);
    }

@Override
    public void describe()
    {
        System.out.println( this.getName() + " (Площадь "  + this.getMaxSquare() + " м^2)" );
    }
}