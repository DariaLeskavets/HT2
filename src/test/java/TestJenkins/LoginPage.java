package TestJenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage {

    @FindBy(xpath = "//form[@name='login']")
    private WebElement form;

    @FindBy(name = "j_username")
    private WebElement name;

    @FindBy(name = "j_password")
    private WebElement password;

    @FindBy(name = "Submit")
    private WebElement loginButton;

    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;

        if(!"Sign in [Jenkins]".equals(driver.getTitle())){
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage setName(String value){
        name.clear();
        name.sendKeys(value);
        return this;
    }

    public LoginPage setPassword(String value){
        password.clear();
        password.sendKeys(value);
        return this;
    }

    public LoginPage submitForm(){
        loginButton.click();
        return this;
    }

    public boolean isFormPresent(){
        if(this.form != null){
            return true;
        } else{
            return false;
        }
    }

   /* public boolean isFormPresentForReal(){

        List<WebElement> listOfForm = (List<WebElement>) ExpectedConditions.
                presenceOfNestedElementLocatedBy(form, By.className("formFow"));
        listOfForm.add((WebElement) ExpectedConditions.
                presenceOfNestedElementLocatedBy(form, By.className("submit formRow")));
        if(listOfForm.size() == 3){
            return true;
        } else{
            return false;
        }
    }*/

    public String getName(){
        return name.getAttribute("value");
    }

    public String getPassword(){
        return password.getAttribute("value");
    }






}
