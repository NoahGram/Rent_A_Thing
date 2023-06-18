import java.util.Scanner;

public class UserLogin {
    static UserAccountSingleton userAccount = UserAccountSingleton.getInstance();
    static Scanner scanner = new Scanner(System.in);
    public static void login() {
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
        scanner.close();
    }

    public void loginValidate(){
        // Check if a user is already logged in
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

    public void logout() {
        userAccount.setCurrentUser(null);
        System.out.println("Logout successful. Goodbye!");
    }
}
