package dev.selenium.tests.assertions;

import dev.selenium.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginAssertions {
    WebDriver driver;
    HomePage hp=new HomePage(driver);

    public void validLoginTest(String actualResult) throws InterruptedException {
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult,expectedResult);
}
    public void invalidLoginTest(String actualResult){
        String expectedResult="Invalid credentials";
        Assert.assertEquals(actualResult,expectedResult);
    }
}
