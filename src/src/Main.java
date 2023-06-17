import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create instances of the factories
        ProductInventorySubject subject = new ProductInventorySubject();

        Rent_a_Thing drillFactory = Rent_a_Thing.getFactory(ProductType.DRILL);
        Rent_a_Thing truckFactory = Rent_a_Thing.getFactory(ProductType.TRUCK);
        Rent_a_Thing carFactory = Rent_a_Thing.getFactory(ProductType.CAR);

        // Create a ProductInventory instance
        ProductInventory productInventory = new ProductInventory(subject);

        // Create and add Products to the inventory
        IProduct drill1 = drillFactory.createDrill("Drillinator 4", "Compound", 10.5, 2.3);
        IProduct drill2 = drillFactory.createDrill("Drillinator 6", "Diamond", 14.5, 4.3);
        IProduct drill3 = drillFactory.createDrill("Drillinator 9", "Steel", 12.0, 3.3);
        IProduct truck1 = truckFactory.createTruck( "Volvo", 1000, 950, 40.6, 23.6);
        IProduct truck2 = truckFactory.createTruck("Mercedes",1300, 1050, 55.5, 27.3);
        IProduct truck3 = truckFactory.createTruck("Tesla",1500, 900, 60.1, 31.4);
        IProduct car1 = carFactory.createCar("Ferrari", 523, 350, 70.1, 4.7);
        IProduct car2 = carFactory.createCar("Audi", 450, 420, 52.4, 2.9);
        IProduct car3 = carFactory.createCar("McLaren", 320, 395, 83.6, 6.4);
        productInventory.addProductToList(drill1);
        productInventory.addProductToList(drill2);
        productInventory.addProductToList(drill3);
        productInventory.addProductToList(truck1);
        productInventory.addProductToList(truck2);
        productInventory.addProductToList(truck3);
        productInventory.addProductToList(car1);
        productInventory.addProductToList(car2);
        productInventory.addProductToList(car3);

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        ProductOverzicht productOverzicht = new ProductOverzicht(subject);

        // Create an instance of the Menu class
        Menu menu = new Menu(productOverzicht, productInventory, scanner);

        menu.loginValidate();
        // Run the menu
        menu.run();

        // Close the scanner
        scanner.close();
    }
}
