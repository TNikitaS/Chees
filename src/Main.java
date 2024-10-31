/* автор Терещенков Никита Сергеевич
 *
 * Задание по 2й лекции
 */
public class Main {
    public static void main(String[] args) {
        String login = "123456789_123456789f";
        String password = "123";
        String confirmPassword = "123";
        if (Authentication.authorization(login,password,confirmPassword)) {
            System.out.println("Проверка прошла успешно");
        }
        else {
            System.out.println("Проверка не пройдена");
        }
    }
}