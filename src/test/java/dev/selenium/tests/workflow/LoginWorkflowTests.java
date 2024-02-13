package dev.selenium.tests.workflow;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import dev.selenium.pages.HomePage;
import dev.selenium.pages.LoginPage;
import dev.selenium.tests.assertions.LoginAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginWorkflowTests {

    WebDriver driver;
    String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");


    @BeforeTest
    public void Setup(){
        extent.attachReporter(spark);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @Test(priority=0)
    public void loginTest() throws InterruptedException {
        Thread.sleep(3000);
        LoginPage login=new LoginPage(driver);
        login.login("Admin","admin123");
        Thread.sleep(3000);
        HomePage hp=new HomePage(driver);
        hp.dashBoardText();
        LoginAssertions la=new LoginAssertions();
        String actualResult = hp.dashBoardText();
        la.validLoginTest(actualResult);
        extent.createTest("login Test").log(Status.PASS,actualResult);
        login.logout();
    }
    @Test(priority = 1)
    public void invalidLoginTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        LoginPage invalidLogin=new LoginPage(driver);
        invalidLogin.login("Admin","admin231");
        HomePage hp=new HomePage(driver);
        LoginAssertions la=new LoginAssertions();
        String actualResult=hp.invalidCredentials();
        la.invalidLoginTest(actualResult);

    }
    @AfterTest
    public void teardown(){
        extent.flush();
        driver.quit();
    }
}
