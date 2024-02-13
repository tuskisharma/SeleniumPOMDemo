package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.TestRunner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.TestRunner.PriorityWeight.priority;

public class POMDemo {
    WebDriver driver;
    @BeforeTest
    public void Setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @Test(priority=0)
    public void LoginTest(){
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedResult="Dashboard";
        String actualResult=driver.findElement(By.xpath("//h6")).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority = 1)
    public void LogoutTest() throws InterruptedException {
        Wait<WebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(70))
                .pollingEvery(Duration.ofMillis(5000)).ignoring(ElementNotInteractableException.class);
        wait.until(d->driver.findElement(By.xpath("//div[@class='oxd-topbar-header-userarea']"))).click();

    }
}
