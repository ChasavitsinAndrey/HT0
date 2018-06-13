public class Chair extends Furniture
{

    public Chair(String name, int minSquare, int maxSquare)
    {
        super(name, minSquare, maxSquare);
    }

    @Override
    public void describe()
    {
        System.out.println( this.getName() + " (Площадь кресла от " + this.getMinSquare() + " м^2 до " + this.getMaxSquare()+ " м^2)" );
    }

}