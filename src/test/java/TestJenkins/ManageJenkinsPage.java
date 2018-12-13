package TestJenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ManageJenkinsPage {

    @FindBy(xpath = "//div[@id='main-panel']/div[16]")
    private WebElement manageUsers;

    private final WebDriver driver;

    public ManageJenkinsPage(WebDriver driver) {
        this.driver = driver;

        if(!"Manage Jenkins [Jenkins]".equals(driver.getTitle())){
            throw new IllegalStateException("Wrong site page");
        }
    }

    public ManageJenkinsPage clickOnManageUsers(){
        Actions actions = new Actions(driver);
        actions.moveToElement(manageUsers, 1, 1).build().perform();
        manageUsers.click();
        return this;
    }
}


