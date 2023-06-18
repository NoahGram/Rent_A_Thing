import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserAccountSingleton {
    private static UserAccountSingleton instance;
    private User currentUser;
    private Customer customer;
    private HashMap<String, User> userMap = new HashMap<>();
    private List<Customer> customerList = new ArrayList<>();

    private UserAccountSingleton() {
        CreateInitialAccounts();
    }

    private void CreateInitialAccounts() {
        addUser(new User("noah", "password1"));
        addUser(new User("bob", "password2"));
    }

    public static synchronized UserAccountSingleton getInstance() {
        if (instance == null) {
            instance = new UserAccountSingleton();
        }
        return instance;
    }

    public boolean UserExists(String username)
    {
        return userMap.containsKey(username);
    }

    public void addUser(User user) {
        if (UserExists(user.getUsername())) {
            return;
        }

        userMap.put(user.getUsername(), user);
    }


    public boolean UserPasswordCorrect(String username, String password) {
        User user = getUser(username);
        return user != null && user.getPassword().equals(password);
    }

    public User getUser(String username) {
        return userMap.get(username);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

}
