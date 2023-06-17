public class CarFactory extends Rent_a_Thing {
    @Override
    public IProduct createDrill(String merk, String type, double price, double verzekering)
    {
        return null;
    }
    @Override
    public IProduct createTruck(String merk, int laadVermogen, int motorInhoud, double huurPrijs, double verzekering) {
        return null;
    }

    @Override
    public  IProduct createCar(String merk, int gewicht, int motorInhoud, double huurPrijs, double verzekering)
    {
        return new Car(merk, gewicht, motorInhoud, huurPrijs, verzekering);
    }

    @Override
    public IProduct createDrill(Rent_a_Thing factory) {
        return null;
    }

    @Override
    public IProduct createTruck(Rent_a_Thing factory) {
        return null;
    }

    @Override
    public IProduct createCar(Rent_a_Thing factory) {
        System.out.print("Enter the Car brand: ");
        String merk = scanner.nextLine();

        System.out.print("Enter the Car Weight: ");
        int gewicht = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the Car Motor Size: ");
        int motorInhoud = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the rental price: ");
        double huurPrijs = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the insurance cost: ");
        double verzekering = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        return factory.createCar(merk, gewicht, motorInhoud, huurPrijs, verzekering);
    }
}
