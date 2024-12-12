import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;

public class TestNGLesson {

    private int value;
    private int powValue;
    private final String NAME = "Nikita";
    private final String PASSWORD = "12345";

    @BeforeClass
    public void setup() {
        value = 5;
        powValue = 3;
    }

    @Test()
    public void aFastTest() {
        assertEquals((int) Math.pow(value, powValue), 125, "Wrong invalid input data");
    }

    @Test(testName = "Validation")
    @Parameters({"login", "password", "confirmPassword"})
    public static void authorization(String login, String password, String confirmPassword) {
        boolean verificationLogin = complianceCheck(login);
        boolean verificationPassword = complianceCheck(password);
        boolean equals = true;
        try {
            if (verificationLogin) {
                throw new WrongLoginException();
            }
            if (verificationPassword) {
                throw new WrongPasswordException();
            } else if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            equals = false;
        }
        assertEquals(equals, true, "Ошибочные входные данные");
    }

    private static boolean complianceCheck(String match) {
        Pattern pattern = Pattern.compile("(\\w{20})|(\\W+)");
        Matcher matching = pattern.matcher(match);
        return (matching.find());
    }

    @Test(dataProvider = "credits")
    public void data_provider_test(String name, String password) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(name, NAME, "Wrong user name");
        softAssert.assertEquals(password, PASSWORD, "Wrong password");
        softAssert.assertAll();
    }

    @DataProvider(name = "credits")
    public static Object[][] provider() {
        return new Object[][]{
                {"Nikita", "12345"},
                {"Vlad", "12345"},
                {"Nikita", "123"}
        };
    }
}
