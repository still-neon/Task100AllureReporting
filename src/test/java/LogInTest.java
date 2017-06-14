import singleton.InstanPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobjects.MailRuLoginPage;
import pageobjects.MailRuMailPage;
import ru.yandex.qatools.allure.annotations.*;
import listeners.LoginTestListener;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertEquals;

@Listeners(LoginTestListener.class)
public class LogInTest {
    private static final String ENTER = "Вход1";
    private static final String EXIT = "выход";
    private WebDriver driver;
    private MailRuLoginPage mailRuLoginPage;
    private MailRuMailPage mailRuMailPage;

    @Parameter("My Param")
    private String myParameter;

    @BeforeMethod
    public void setUp() {
        driver = InstanPage.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @AfterClass
    public void tearDown() {
        InstanPage.close();
    }

    @Features("LogIn")
    @Description("The method tests user's log in the system")
    @TestCaseId("TMS-1")
    @Test
    public void loginTest() throws InterruptedException {
        myParameter = "Browser: Google Chrome";
        myParameter = "Browser's version: 57.0.2987.133 (64-bit)";
        mailRuLoginPage = new MailRuLoginPage(driver);
        mailRuLoginPage.load();
        mailRuMailPage = mailRuLoginPage.login();
        Thread.sleep(500);
        assertEquals(mailRuMailPage.getExitValue(), EXIT);
        mailRuLoginPage = mailRuMailPage.logout();
    }

    @Features("LogOut")
    @Description("The method tests user's log out from the system")
    @TestCaseId("TMS-2")
    @Test
    public void logoutTest() throws InterruptedException {
        myParameter = "Browser: Google Chrome";
        myParameter = "Browser's version: 57.0.2987.133 (64-bit)";
        mailRuLoginPage = new MailRuLoginPage(driver);
        mailRuLoginPage.load();
        mailRuMailPage = mailRuLoginPage.login();
        Thread.sleep(500);
        mailRuLoginPage = mailRuMailPage.logout();
        assertEquals(mailRuLoginPage.getEnterValue(), ENTER);
    }
}