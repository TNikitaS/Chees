public class WrongPasswordException extends Exception{
    WrongPasswordException() {
        super("Пароль введён в недопустимом формате");
    }
    WrongPasswordException(String message) {
        super(message);
    }
}
