package logic;

public class LoginException extends Exception {
    public LoginException() {
        super("Error de autenticación");
    }
    
    public LoginException(String message) {
        super(message);
    }
}