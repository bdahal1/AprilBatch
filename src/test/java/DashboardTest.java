import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.DashboardPage;
import pageObject.LoginPage;

import java.time.Duration;

public class DashboardTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;
    private String baseUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        loginPage= new LoginPage(driver);
        loginPage.login("admin", "admin123");
        dashboardPage = new DashboardPage(driver);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void dashboardPageTest() {

    }
}
