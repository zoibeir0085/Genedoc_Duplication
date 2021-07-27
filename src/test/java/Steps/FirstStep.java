package Steps;

//import cucumber.api.DataTable;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;


import Pages.* ;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import cucumber.api.DataTable;


public class FirstStep {
    WebDriver driver;


    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("Navigate login page");
        try {
        //for linux
        System.setProperty("webdriver.chrome.driver","chromedriver");


        Map<String, Object> prefs = new HashMap<String, Object>();

        //To Turns off multiple download warning
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.navigate().to("https://aezan.genedoc.fr/Login");
        } catch (Exception e) {
            System.out.println("ChromeDriver for Windows");
        }

        try {

            //for windows
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


            Map<String, Object> prefs = new HashMap<String, Object>();

            //To Turns off multiple download warning
            prefs.put("profile.default_content_setting_values.automatic_downloads", 1);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);

            driver.manage().window().maximize();

            driver.navigate().to("https://aezan.genedoc.fr/Login");
        } catch (Exception e) {
            System.out.println("ChromeDriver for Linux");
        }

    }


    @And("I click login button")
    public void iClickLoginButton() throws InterruptedException {
        // System.out.println("Click login button");

        LoginPage page = new LoginPage(driver);

        page.ClickLogin();
        Thread.sleep(15000);
    }

    @Then("I should see the welcome page")
    public void iShouldSeeTheUserformPage() {
        System.out.println("I should see userform");
        //Assert.assertEquals("its not displayed",driver.findElement(By.className("container body-content")).isDisplayed(),true );


        //driver.findElement(By.name("generate")).click() ;


    }

    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterUsernameAndPassword(String username, String password) throws InterruptedException {
        LoginPage page = new LoginPage(driver);
        page.Login(username, password);
        Thread.sleep(2000);
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() throws InterruptedException {
        Thread.sleep(1);
        driver.quit();
        driver = null;
    }

    @Then("I navigate to the creation of new folder page")
    public void iNavigateToTheCreationOfNewFolderPage() throws InterruptedException {
        WelcomePage page = new WelcomePage(driver);
        page.goToNouveauDossier();
        Thread.sleep(2000);

    }

    @Then("I archieve")
    public void iArchieve() throws InterruptedException {
        WelcomePage page = new WelcomePage(driver);
        page.archiver(driver);
    }

    @Then("I cancel archieve")
    public void iCancelArchieve() throws InterruptedException {
        WelcomePage page = new WelcomePage(driver);
        page.desarchiver(driver);

    }

    @Then("I duplicate folder")
    public void iDuplicateFolder() throws InterruptedException {
        WelcomePage page = new WelcomePage(driver);
        page.dupliquer(driver);
    }

    @Then("I delete duplicated folder")
    public void iDeleteDuplicatedFolder() throws InterruptedException {
        WelcomePage page = new WelcomePage(driver);
        page.supprimerDuplicated(driver);
    }
}