package TestJenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.Page;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestOfJenkins {

    String base_url = "http://localhost:8080/";
    StringBuffer verificationErrors = new StringBuffer();
    WebDriver driver = null;
    String chromedriver_path = "D:\\ChromeDriver\\chromedriver.exe";

    private String username = "someuser";
    private String password = "somepassword";
    private String fullname = "Some Full Name";
    private String email = "some@addr.dom";

    @BeforeClass
    public void beforeClass() throws IOException {
        System.setProperty("webdriver.chrome.driver", chromedriver_path);
        ChromeOptions options = new ChromeOptions();
        options.setCapability("chrome.switсhes", Arrays.asList("--homepage=about:blank"));
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void afterClass(){

        //driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if(!"".equals(verificationErrorString)){
            Assert.fail(verificationErrorString);
        }

    }

    @Test(priority = 1)
    public void logIn(){
       driver.get(base_url);
       LoginPage page = PageFactory.initElements(driver, LoginPage.class);

       Assert.assertTrue(page.isFormPresent(), "Form isn't exist!");
      // Assert.assertTrue(page.isFormPresentForReal(), "No suitable forms found!");

       page.setName("Daria");
       Assert.assertEquals(page.getName(), "Daria",
               "Unable to fill 'Daria' field");
       page.setPassword("dariatat2018");
       Assert.assertEquals(page.getPassword(), "dariatat2018",
               "Unable to fill 'Daria' field");
       page.submitForm();
       Assert.assertEquals(driver.getTitle(), "Dashboard [Jenkins]",
               "Authorization is failed");
    }

    @Test(priority = 2)
    public void manageJenkins(){
        ManagePage page = PageFactory.initElements(driver, ManagePage.class);
        page.clickOnManage();
        Assert.assertEquals(driver.getTitle(), "Manage Jenkins [Jenkins]",
                "Webpage didn't open");
    }

    @Test(priority = 3)
    public void manageUsers(){
        ManageJenkinsPage page = PageFactory.initElements(driver, ManageJenkinsPage.class);
        page.clickOnManageUsers();
        Assert.assertEquals(driver.getTitle(), "Users [Jenkins]",
                "Webpage didn't open");
    }

    @Test(priority = 4)
    public void goToCreateUser(){
        UsersPage page = PageFactory.initElements(driver, UsersPage.class);
        page.clickOnCreateUser();
        Assert.assertEquals(driver.getTitle(), "Create User [Jenkins]",
                "Webpage didn't open" );
    }

    @Test(priority = 5)
    public void createUser(){
        CreateUserPage page = PageFactory.initElements(driver, CreateUserPage.class);

        Assert.assertTrue(page.isFormPresent(), "Form isn't exist!");

        page.setUsername_locator(username);
        Assert.assertEquals(page.getUsername_locator(), username,
                "Unable to fill '" + username + "' field" );

        page.setPassword_locator(password);
        Assert.assertEquals(page.getPassword_locator(), password,
                "Unable to fill '" + password + "' field");

        page.setPasswConf_locator(password);
        Assert.assertEquals(page.getPasswConf_locator(),  password,
                "Unable to fill '" + password + "' field");

        page.setFullname_locator(fullname);
        Assert.assertEquals(page.getFullname_locator(), fullname,
                "Unable to fill '" + fullname + "' field");

        page.setEmail_locator(email);
        Assert.assertEquals(page.getEmail_locator(), email,
                "Unable to fill '" + email + "' field");

        page.submitForm();
        Assert.assertEquals(driver.getTitle(), "Users [Jenkins]",
                "Authorization is failed");
    }

    @Test(priority = 6)
    public void deleteUser (){
        DeleteUserPage page = PageFactory.initElements(driver, DeleteUserPage.class);
        page.clickOn(page.getDeleteButton());
        Assert.assertEquals(driver.getTitle(), "Jenkins",
                "Webpage didn't open");
        page.clickOn(page.getYesButton());
        Assert.assertEquals(driver.getTitle(), "Users [Jenkins]",
                "Webpage didn't open");

       Assert.assertTrue(page.isAbsentElement());
       Assert.assertTrue(page.isAbsentDeleteUserLink());
       Assert.assertTrue(page.isAbsentDeleteAdminLink());
    }
}
