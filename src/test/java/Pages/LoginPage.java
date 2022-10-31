package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    public WebElement textUserName;

    @FindBy(css = "[type = password]")
    public WebElement textPassword;

    @FindBy(css = "[type = submit]")
    public WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doLogin() {
        textUserName.sendKeys("admin");
        textPassword.sendKeys("admin123");
        buttonSubmit.click();
    }
}
