package trello.auto.task.pages;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
import static trello.auto.task.TestProperties.getHomePageUrl;

public class LoginPage {

    private static final String LOGIN_XPATH = "//body[@data-track-group='Landing-Marquee']/header/nav/div[2]/a[1]";
    private static final String USERNAME_ID = "user";
    private static final String PASSWORD_ID = "password";
    private static final String SUBMIT_LOGIN_ID = "login";


    private final WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void goToHomePage() {
        driver.get(getHomePageUrl());
    }

    public void goToLoginPage() {
        driver.findElement(xpath(LOGIN_XPATH)).click();
    }

    public void fillUsername(String email){
        driver.findElement(id(USERNAME_ID)).sendKeys(email);
    }

    public void fillPassword(String password){
        driver.findElement(id(PASSWORD_ID)).sendKeys(password);
    }

    public void submitLoginForm() {
        driver.findElement(id(SUBMIT_LOGIN_ID)).submit();
    }

    public boolean isLoginSucceeded() {
        return driver.getCurrentUrl().contains("boards");
    }

}
