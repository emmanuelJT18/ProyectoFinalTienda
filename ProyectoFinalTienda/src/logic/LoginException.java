package logic;

public class LoginException extends Exception {
    public LoginException() {
        super("Error de autenticaci�n");
    }
    
    public LoginException(String message) {
        super(message);
    }
}