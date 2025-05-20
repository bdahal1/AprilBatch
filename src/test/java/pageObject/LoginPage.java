package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public By usernameEle=By.name("username");
    public By passwordEle=By.xpath("//input[@name='password']");
    public By loginBtnEle=By.tagName("button");

    public By invalidErrorMsgEle=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    public By usernameRequiredErrorMsgEle=By.xpath("//input[@name='username']/parent::div/following-sibling::span");
    public By passwordRequiredErrorMsgEle=By.xpath("//input[@name='password']/parent::div/following-sibling::span");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameEle).sendKeys(username);
        driver.findElement(passwordEle).sendKeys(password);
        driver.findElement(loginBtnEle).click();
    }

}
