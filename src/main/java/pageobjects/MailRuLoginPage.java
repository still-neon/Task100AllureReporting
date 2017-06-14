package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailRuLoginPage {
    private static final String LOGIN = "seleniumtests10@mail.ru";
    private static final String PASSWORD = "060788avavav";
    private String URL = "http://mail.ru";
    private static final By login = By.id("mailbox__login");
    private static final By password = By.id("mailbox__password");
    private static final By enterButton = By.id("mailbox__auth__button");
    private static final By enterLink = By.id("PH_authLink");
        private WebDriver driver;

    public MailRuLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void load() {
        driver.get(URL);
    }

    public MailRuMailPage login() throws InterruptedException {
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys(LOGIN);
        driver.findElement(password).sendKeys(PASSWORD);
        driver.findElement(enterButton).click();
        return new MailRuMailPage(driver);
    }

    public MailRuMailPage login(String login, String password) {
        driver.findElement(this.login).clear();
        driver.findElement(this.login).sendKeys(login);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(enterButton).click();
        return new MailRuMailPage(driver);
    }

    public String getEnterValue() {
        return driver.findElement(enterLink).getText();
    }
}