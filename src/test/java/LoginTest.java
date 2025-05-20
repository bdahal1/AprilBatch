import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.DashboardPage;
import pageObject.LoginPage;

import java.time.Duration;

public class LoginTest {
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
        dashboardPage = new DashboardPage(driver);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginPositiveTest() {
        loginPage.login("admin", "admin123");
        String actualValue=driver.findElement(dashboardPage.dashboardTextEle).getText();
        Assertions.assertEquals("Dashboard", actualValue);
    }
    @Test
    public void loginNegativeTest1() {
        loginPage.login("admin", "admin1234");
        String actualValue=driver.findElement(loginPage.invalidErrorMsgEle).getText();
        Assertions.assertEquals("Invalid credentials", actualValue);
    }
    @Test
    public void loginNegativeTest2() {
        loginPage.login("admin2", "admin123");
        String actualValue=driver.findElement(loginPage.invalidErrorMsgEle).getText();
        Assertions.assertEquals("Invalid credentials", actualValue);
    }
    @Test
    public void loginNegativeTest3() {
        loginPage.login("admin2", "admin1234");
        String actualValue=driver.findElement(loginPage.invalidErrorMsgEle).getText();
        Assertions.assertEquals("Invalid credentials", actualValue);
    }

    @Test
    public void loginNegativeTest4() {
        loginPage.login("", "");
        String actualValue=driver.findElement(loginPage.usernameRequiredErrorMsgEle).getText();
        Assertions.assertEquals("Required", actualValue);
        actualValue=driver.findElement(loginPage.passwordRequiredErrorMsgEle).getText();
        Assertions.assertEquals("Required", actualValue);
    }
}
