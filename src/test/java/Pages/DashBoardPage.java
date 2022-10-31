package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardPage {

    @FindBy(className = "oxd-userdropdown-img")
    public WebElement imageProfile;

    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> dropDowns;

    @FindBy(css = "[type = submit]")
    public WebElement buttonSubmit;

    public DashBoardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
