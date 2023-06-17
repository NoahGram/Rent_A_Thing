public class TruckFactory extends Rent_a_Thing {
    @Override
    public IProduct createDrill(String merk, String type, double price, double verzekering)
    {
        return null;
    }

    @Override
    public IProduct createTruck(String merk, int laadVermogen, int motorInhoud, double huurPrijs, double verzekering) {
        return new Truck(merk, laadVermogen, motorInhoud, huurPrijs, verzekering);
    }

    @Override
    public  IProduct createCar(String merk, int gewicht, int motorInhoud, double huurPrijs, double verzekering)
    {
        return null;
    }

    @Override
    public IProduct createDrill(Rent_a_Thing factory) {
        return null;
    }

    @Override
    public IProduct createTruck(Rent_a_Thing factory) {
        System.out.print("Enter the Truck brand: ");
        String merk = scanner.nextLine();

        System.out.print("Enter the Truck Weight Storage: ");
        int laadVermogen = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the Truck Motor Size: ");
        int motorInhoud = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the rental price: ");
        double huurPrijs = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the insurance cost: ");
        double verzekering = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        return factory.createTruck(merk, laadVermogen, motorInhoud, huurPrijs, verzekering);
    }

    @Override
    public IProduct createCar(Rent_a_Thing factory) {
        return null;
    }
}
