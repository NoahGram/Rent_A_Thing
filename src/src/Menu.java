import java.util.List;
import java.util.Scanner;

public class Menu {
    private ProductOverzicht productOverzicht;
    private ProductInventory productInventory;
    private Scanner scanner;

    public Menu(ProductOverzicht productOverzicht, ProductInventory productInventory, Scanner scanner) {
        this.productOverzicht = productOverzicht;
        this.productInventory = productInventory;
        this.scanner = scanner;
    }

    public void run() {
        UserLogin user = new UserLogin();
        user.loginValidate();
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    productOverzicht.showAllProducts(productInventory);
                    break;
                case 2:
                    productOverzicht.searchProductType(productInventory);
                    break;
                case 3:
                    user.loginValidate();
                    break;
                case 4:
                    user.logout();
                    break;
                case 5:
                    exit = true;
                    break;
                case 6:
                    productInventory.addProductToInventory();
                    break;
                case 7:
                    productInventory.removeProductFromInventory();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        User currentUser = UserAccountSingleton.getInstance().getCurrentUser();
        System.out.println("Menu: " + "Logged in as: " + (currentUser != null ? currentUser.getUsername() : "Guest"));
        System.out.println("1. Show all products");
        System.out.println("2. Search for a product");
        System.out.println("3. Login");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        System.out.println("6. Add product to inventory");
        System.out.println("7. Remove product from inventory");
        System.out.print("Enter your choice: ");
    }
}