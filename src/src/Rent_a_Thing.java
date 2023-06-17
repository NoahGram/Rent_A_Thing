import java.util.Scanner;

enum ProductType {
    TRUCK, DRILL, CAR
}

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

    public abstract IProduct createDrill(Rent_a_Thing factory);
    public abstract IProduct createTruck(Rent_a_Thing factory);
    public abstract IProduct createCar(Rent_a_Thing factory);
}
