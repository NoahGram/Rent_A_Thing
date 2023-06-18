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
                    if (UserAccountSingleton.getInstance().getCurrentUser().getUsername() != null) {
                        System.out.println("Logged in as: " + UserAccountSingleton.getInstance().getCurrentUser().getUsername());
                        break;
                    }
                    UserLogin.login();
                    break;
                case 4:
                    if (UserAccountSingleton.getInstance().getCurrentUser() != null) {
                        UserAccountSingleton.getInstance().setCurrentUser(null);
                        System.out.println("Logout successful. Goodbye!");
                    } else {
                        System.out.println("No user currently logged in.");
                    }
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
        System.out.println("Menu: " + "Logged in as: " + UserAccountSingleton.getInstance().getCurrentUser().getUsername());
        System.out.println("1. Show all products");
        System.out.println("2. Search for a product");
        System.out.println("3. Show User");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        System.out.println("6. Add product to inventory");
        System.out.println("7. Remove product from inventory");
        System.out.print("Enter your choice: ");
    }

    public void loginValidate(){
        // Check if a user is already logged in
        UserAccountSingleton userAccount = UserAccountSingleton.getInstance();
        if (userAccount.getCurrentUser() == null) {
            boolean loginSuccessful = false;
            while (!loginSuccessful) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                loginSuccessful = userAccount.UserPasswordCorrect(username, password);
                if (loginSuccessful) {
                    userAccount.setCurrentUser(userAccount.getUser(username));
                    System.out.println("Login successful. Welcome, " + username + "!");
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            }
        } else {
            System.out.println("Logged in as: " + userAccount.getCurrentUser().getUsername());
        }
    }
}