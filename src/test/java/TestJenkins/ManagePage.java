package TestJenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class ManagePage {

    @FindBy(linkText = "Manage Jenkins")
    private WebElement manageLink;

    private final WebDriver driver;

    public ManagePage(WebDriver driver) {
        this.driver = driver;

        if(!"Dashboard [Jenkins]".equals(driver.getTitle())){
            throw new IllegalStateException("This is not the login page");
        }
    }

    public ManagePage clickOnManage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(manageLink, 1, 1).build().perform();
        manageLink.click();
        return this;
    }
}
