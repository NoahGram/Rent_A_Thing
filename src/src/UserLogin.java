import java.util.Scanner;

public class UserLogin {
    public static void login() {
        UserAccountSingleton userAccount = UserAccountSingleton.getInstance();
        Scanner scanner = new Scanner(System.in);

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
}
