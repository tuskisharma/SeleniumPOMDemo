package dev.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;

    By usenameBy= By.name("username");
    By passwordBy= By.name("password");
    By submitButtonBy= By.xpath("//button[@type='submit']");

    By logoutOptionBy=By.xpath("//div[@class='oxd-topbar-header-userarea']");

    By logoutClick=By.partialLinkText("Logout");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void login(String username,String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(usenameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(submitButtonBy).click();

    }
    public void logout(){
        driver.findElement(logoutOptionBy).click();
        driver.findElement(logoutClick).click();
    }
}
