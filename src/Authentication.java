import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authentication {
    public static boolean authorization(String login,String password, String confirmPassword) {
        boolean verificationLogin = complianceCheck(login);
        boolean verificationPassword = complianceCheck(password);
        try {
            if (verificationLogin) {
                throw new WrongLoginException();
            }
            if (verificationPassword) {
                throw new WrongPasswordException();
            }
            else if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        }
        catch (WrongLoginException e) {
            e.printStackTrace();
            return false;
        }
        catch (WrongPasswordException s) {
            s.printStackTrace();
            return false;
        }
        return true;
    }
    private static boolean complianceCheck(String match) {
        Pattern pattern = Pattern.compile("(\\w{20})|(\\W+)");
        Matcher matching = pattern.matcher(match);
        return (matching.find());
    }
}