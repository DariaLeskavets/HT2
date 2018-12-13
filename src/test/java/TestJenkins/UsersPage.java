package TestJenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UsersPage {

    @FindBy(linkText = "Create User")
    private WebElement linkCreateUser;

    private final WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;

        if(!"Users [Jenkins]".equals(driver.getTitle())){
            throw new IllegalStateException("Wrong site page");
        }
    }

    public UsersPage clickOnCreateUser(){
        Actions actions = new Actions(driver);
        actions.moveToElement(linkCreateUser, 1, 1).build().perform();
        linkCreateUser.click();
        return this;
    }
}
