package Model;

public class Admin {
    private String username = "a";
    private String password = "a";
    
    public boolean isValidAdmin(String enteredUsername, String enteredPassword)
    {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }
}
