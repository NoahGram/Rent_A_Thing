import java.util.HashMap;

public class UserAccountSingleton {
    private static UserAccountSingleton instance;
    private User currentUser;
    private HashMap<String, User> userMap = new HashMap<>();

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
}
