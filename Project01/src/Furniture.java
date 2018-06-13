public abstract class Furniture
{

    private String name;
    private int minSquare;
    private int maxSquare;

    public Furniture(String name, int minSquare, int maxSquare)
    {
        this.name = name;
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    public String getName()
    {
        return name;
    }

    public int getMinSquare()
    {
        return minSquare;
    }

    public int getMaxSquare()
    {
        return maxSquare;
    }

    public void describe()
    {

    }
}