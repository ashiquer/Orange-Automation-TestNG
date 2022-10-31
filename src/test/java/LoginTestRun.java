import Pages.DashBoardPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class LoginTestRun extends Setup {

    DashBoardPage dashBoardPage;
    LoginPage loginPage;

    @Test(priority = 1)

    public void doLogin(){
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);
        loginPage.doLogin();

        String systemURL = driver.getCurrentUrl();
        String expectedURL = "viewEmployeeList";
        Assert.assertTrue(systemURL.contains(expectedURL));
    }

    @Test(priority = 2)

    public void isProfileImageExists(){
        dashBoardPage = new DashBoardPage(driver);
        Assert.assertTrue(dashBoardPage.imageProfile.isDisplayed());
//       WebElement imageProfile = driver.findElement(By.className("oxd-userdropdown-img"));
//       Assert.assertTrue(imageProfile.isDisplayed());
    }

    @Test(priority = 3)

    public void selectEmploymentStatus() throws InterruptedException {
        dashBoardPage.dropDowns.get(0).click();
        dashBoardPage.dropDowns.get(0).sendKeys(Keys.ARROW_DOWN);
        dashBoardPage.dropDowns.get(0).sendKeys(Keys.ARROW_DOWN);
        dashBoardPage.dropDowns.get(0).sendKeys(Keys.ENTER);
        dashBoardPage.buttonSubmit.click();

        Thread.sleep(3000);

        List<WebElement> textData = driver.findElements(By.tagName("span"));
        String systemData = textData.get(14).getText();
        String expectedData = "Records Found";
        Assert.assertTrue(systemData.contains(expectedData));
    }

    @Test(priority = 4)

    public void listEmployee(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        WebElement table = driver.findElement(By.className("oxd-table-body"));
        List<WebElement> allRows = table.findElements(By.cssSelector("[role = row]"));

        for (WebElement row : allRows){
           List<WebElement> cells = row.findElements(By.cssSelector("[role = cell]"));
            System.out.println(cells.get(5).getText());
            Assert.assertTrue(cells.get(5).getText().contains("Full-Time Contract"));
        }
    }
}
