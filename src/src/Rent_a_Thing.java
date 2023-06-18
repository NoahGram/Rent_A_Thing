import java.util.Scanner;

public abstract class Rent_a_Thing {
    protected Scanner scanner = new Scanner(System.in);
    static Rent_a_Thing getFactory(ProductType type)
    {
        switch(type)
        {
            case DRILL :
                return new DrillFactory();

            case CAR :
                return new CarFactory();

            case TRUCK:
                return new TruckFactory();
        }

        return null;
    }

    public abstract IProduct createDrill(String merk, String type, double price, double verzekering);
    public abstract IProduct createTruck(String merk, int laadVermogen, int motorInhoud, double huurPrijs, double verzekering);
    public abstract IProduct createCar(String merk, int gewicht, int motorInhoud, double huurPrijs, double verzekering);

    public abstract IProduct createCustomDrill(Rent_a_Thing factory);
    public abstract IProduct createCustomTruck(Rent_a_Thing factory);
    public abstract IProduct createCustomCar(Rent_a_Thing factory);
}
