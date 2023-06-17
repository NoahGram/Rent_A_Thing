import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductInventory implements IProductObserver {
    private Scanner scanner = new Scanner(System.in);
    private List<IProduct> products;
    private ProductInventorySubject subject;

    public ProductInventory(ProductInventorySubject subject) {
        this.subject = subject;
        products = new ArrayList<>();
        subject.addObserver(this::inventoryUpdate);
    }

    public void addProductToInventory() {
        System.out.print("Enter the product type (Drill, Truck, Car): ");
        String productType = scanner.nextLine();

        Rent_a_Thing factory = Rent_a_Thing.getFactory(ProductType.valueOf(productType.toUpperCase()));
        if (factory == null) {
            System.out.println("Invalid product type. Please try again.");
            return;
        }

        IProduct product = null;
        switch (productType.toLowerCase()) {
            case "drill":
                product = factory.createDrill(factory);
                break;
            case "truck":
                product = factory.createTruck(factory);
                break;
            case "car":
                product = factory.createCar(factory);
                break;
            default:
                System.out.println("Invalid product type. Please try again.");
        }

        if (product != null) {
            addProductToList(product);
            System.out.println("Product added to inventory.");
        }
        System.out.println();
    }

    public void addProductToList(IProduct product) {
        products.add(product);
        //Observer
        subject.notifyObservers();
    }

    public void removeProductFromInventory() {
        System.out.println("Select the product to remove:");
        List<IProduct> products = getProducts();
        for (int i = 0; i < products.size(); i++) {
            IProduct product = products.get(i);
            String productName = "";
            if (product instanceof Drill) {
                Drill drill = (Drill) product;
                productName = "Drill: " + drill.getMerk() + ", Type: " + drill.getType();
            } else if (product instanceof Truck) {
                Truck truck = (Truck) product;
                productName = "Truck: " + truck.getMerk() + ", LaadVermogen: " + truck.getLaadVermogen() + "KG, MotorInhoud: " + truck.getMotorInhoud() + "L";
            } else if (product instanceof Car) {
                Car car = (Car) product;
                productName = "Car: " + car.getMerk() + ", Gewicht: " + car.getGewicht();
            }
            System.out.println((i + 1) + ". " + productName);
        }

        System.out.print("Enter the product number to remove: ");
        int productNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (productNumber < 1 || productNumber > products.size()) {
            System.out.println("Invalid product number. Please try again.");
            return;
        }

        IProduct productToRemove = products.get(productNumber - 1);
        products.remove(productToRemove);
        System.out.println("Product removed from inventory.");
        subject.notifyObservers();
        System.out.println();
    }

    public List<IProduct> getProducts() {
        return products;
    }

    @Override
    public void inventoryUpdate() {
        System.out.println("Product inventory updated. Refreshing the product inventory...");
    }
}
