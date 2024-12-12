public class WrongLoginException extends Exception {
    WrongLoginException() {
        super("Логин введён в недопустимом формате");
    }
    WrongLoginException(String message) {
        super(message);
    }
}
