package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailRuMailPage {
    private static final By exitLink = By.id("PH_logoutLink");
    private WebDriver driver;

    public MailRuMailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getExitValue() {
        return driver.findElement(exitLink).getText();
    }

    public MailRuLoginPage logout() {
        driver.findElement(exitLink).click();
        return new MailRuLoginPage(driver);
    }
}