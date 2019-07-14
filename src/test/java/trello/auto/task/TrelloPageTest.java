package trello.auto.task;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import trello.auto.task.pages.BoardPage;
import trello.auto.task.pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class TrelloPageTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/s.cherif/IdeaProjects/chromedriver");
		driver = new ChromeDriver();

	}

	@Ignore
	@Test
	public void check_the_login_page() throws InterruptedException {
		LoginPage page = new LoginPage(driver);
		page.goToHomePage();
		page.goToLoginPage();
		page.fillUsername("sabrine.cheriff@gmail.com");
		page.fillPassword("Yk23faeT2DMSz4Q");
		page.submitLoginForm();
		Thread.sleep(2000);
		assertThat(page.isLoginSucceeded()).isTrue();
	}

	@Test
	public void check_team_creation() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goToHomePage();
		loginPage.goToLoginPage();
		loginPage.fillUsername("sabrine.cheriff@gmail.com");
		loginPage.fillPassword("Yk23faeT2DMSz4Q");
		loginPage.submitLoginForm();
		Thread.sleep(2000);

		BoardPage boardPage = new BoardPage(driver);
		boardPage.createTeam();
		boardPage.fillTeamName("TestTeam");
		boardPage.fillTeamDescription("Team description");
		boardPage.submitTeamCreation();
		Thread.sleep(2000);
		assertThat(boardPage.isTeamCreationSucceeded("TestTeam")).isTrue();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}