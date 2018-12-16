package TestJenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public class DeleteUserPage {

    @FindBy(xpath = "//table/tbody/tr[3]/td[4]/a[2]")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[@id='main-panel']/form/span/span/button")
    private WebElement yesButton;

    private final WebDriver driver;

    public DeleteUserPage(WebDriver driver) {
        this.driver = driver;

        if(!"Users [Jenkins]".equals(driver.getTitle())){
            throw new IllegalStateException("This is not the login page");
        }
    }

    public DeleteUserPage clickOn(WebElement button){
        Actions actions = new Actions(driver);
        actions.moveToElement(button, 1, 1).build().perform();
        button.click();
        return this;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getYesButton() {
        return yesButton;
    }

    public boolean isAbsentElement(){
        try {
            WebElement userLink = driver.findElement(By.xpath("//table//a[@href='user/someuser/']"));
            return false;
        } catch (NoSuchElementException e){
            return true;
        }
    }

    public boolean isAbsentDeleteUserLink(){
        try{
            WebElement delet_locator = driver.findElement(By.linkText("user/someuser/delete"));
            return false;
        } catch (NoSuchElementException e){
            return true;
        }
    }

    public boolean isAbsentDeleteAdminLink(){
        try{
            WebElement delet_locator = driver.findElement(By.linkText("user/admin/delete"));
            return false;
        } catch (NoSuchElementException e){
            return true;
        }
    }
}
