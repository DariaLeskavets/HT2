package TestJenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {

    @FindBy(xpath = "//div[@id='main-panel']/form")
    private WebElement form_locator;

    @FindBy(name = "username")
    private WebElement username_locator;

    @FindBy(name = "password1")
    private WebElement password_locator;

    @FindBy(name = "password2")
    private WebElement passwConf_locator;

    @FindBy(name = "fullname")
    private WebElement fullname_locator;

    @FindBy(name = "email")
    private WebElement email_locator;

    @FindBy(xpath = "//div[@id='main-panel']/form/span/span/button")
    private WebElement submit_locator;

    private WebDriver driver;

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;

        if(!"Create User [Jenkins]".equals(driver.getTitle())){
            throw new IllegalStateException("Wrong site page");
        }
    }

    public CreateUserPage setUsername_locator(String value) {
        username_locator.clear();
        username_locator.sendKeys(value);
        return this;
    }

    public CreateUserPage setPassword_locator(String value) {
        password_locator.clear();
        password_locator.sendKeys(value);
        return this;
    }

    public CreateUserPage setPasswConf_locator(String value) {
        passwConf_locator.clear();
        passwConf_locator.sendKeys(value);
        return this;
    }

    public CreateUserPage setFullname_locator(String value) {
        fullname_locator.clear();
        fullname_locator.sendKeys(value);
        return this;
    }

    public CreateUserPage setEmail_locator(String value) {
        email_locator.clear();
        email_locator.sendKeys(value);
        return this;
    }

    public boolean isFormPresent(){
        if(this.form_locator != null){
            return true;
        } else{
            return false;
        }
    }

    public CreateUserPage submitForm(){
        submit_locator.click();
        return this;
    }

    public String getUsername_locator() {
        return username_locator.getAttribute("value");
    }

    public String getPassword_locator() {
        return password_locator.getAttribute("value");
    }

    public String getPasswConf_locator() {
        return passwConf_locator.getAttribute("value");
    }

    public String getFullname_locator() {
        return fullname_locator.getAttribute("value");
    }

    public String getEmail_locator() {
        return email_locator.getAttribute("value");
    }
}
