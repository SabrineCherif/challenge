package trello.auto.task.pages;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class BoardPage {


    private static final String CREATE_TEAM_BT_XPATH = "//button[@data-test-id='home-navigation-create-team-button']";
    private static final String TEAM_NAME_ID = "org-display-name";
    private static final String TEAM_DESC_ID = "org-desc";
    private static final String CREATE_BTN =  "//input[@type='submit']";

    private final WebDriver driver;

    public BoardPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void createTeam() {
        driver.findElement(xpath(CREATE_TEAM_BT_XPATH)).submit();
    }

    public void fillTeamName(String name){
        driver.findElement(id(TEAM_NAME_ID)).sendKeys(name);
    }

    public void fillTeamDescription(String desc){
        driver.findElement(id(TEAM_DESC_ID)).sendKeys(desc);
    }

    public void submitTeamCreation() {
        driver.findElement(xpath(CREATE_BTN)).click();
    }

    public boolean isTeamCreationSucceeded(String teamName) {
        return driver.getCurrentUrl().contains(teamName.toLowerCase());
    }
}
