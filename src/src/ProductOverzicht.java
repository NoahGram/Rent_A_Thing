import java.util.List;
import java.util.Scanner;

public class ProductOverzicht implements IProductObserver {
    private Scanner scanner = new Scanner(System.in);
    private ProductRental rentProduct = new ProductRental();

    public ProductOverzicht(ProductInventorySubject subject) {
        subject.addObserver(this::inventoryUpdate);
    }

    public void showAllProducts(ProductInventory productInventory) {
        List<IProduct> products = productInventory.getProducts();
        System.out.println("All Products:");
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
        System.out.println("0. Back");
        System.out.print("Enter the number of the product for details: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice > 0 && choice <= products.size()) {
            IProduct selectedProduct = products.get(choice - 1);
            showProductDetails(selectedProduct);
        } else if (choice != 0) {
            System.out.println("Invalid choice. Please try again.");
        }
        System.out.println();
    }

    private void showProductDetails(IProduct product) {
        System.out.println("Product Details:");
        String username = UserAccountSingleton.getInstance().getCurrentUser().getUsername();

        System.out.println(product.GetDetails());
        System.out.println(product.createPriceCalculator().berekenHuurPrijs());
        if (product.isRented()){
            System.out.println("isRented: " + product.isRented());
            System.out.println("Medewerker: " + username);
            rentProduct.rentOptions(product);
        } else {
            System.out.println("isRented: " + product.isRented());
            rentProduct.rentOptions(product);
        }
        System.out.println();
    }


    public void searchProductType(ProductInventory productInventory) {
        System.out.print("Enter the product type (Drill, Truck, Car): ");
        String productType = scanner.nextLine();

        List<IProduct> products = productInventory.getProducts();
        boolean found = false;

        for (IProduct product : products) {
            if (product.getClass().getSimpleName().equalsIgnoreCase(productType)) {
                found = true;
                System.out.println("Product Found:");
                System.out.println(product.GetDetails());

/*
                if (product instanceof Drill) {
                    Drill drill = (Drill) product;
                    System.out.println("Drill: " + drill.getMerk() + ", Type: " + drill.getType());

                } else if (product instanceof Truck) {
                    Truck truck = (Truck) product;
                    System.out.println("Truck: " + truck.getMerk() + ", LaadVermogen: " + truck.getLaadVermogen() + "KG, MotorInhoud: " + truck.getMotorInhoud() + "L");
                } else if (product instanceof Car) {
                    Car car = (Car) product;
                    System.out.println("Car: " + car.getMerk() + ", Gewicht: " + car.getGewicht());
                }
*/
                System.out.println();
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }

        System.out.println();
    }

    @Override
    public void inventoryUpdate() {
        System.out.println("Product inventory updated. Refreshing the product overview...");
    }
}
