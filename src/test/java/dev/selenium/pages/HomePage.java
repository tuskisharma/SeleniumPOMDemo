package dev.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    By dashBoardLabelBy= By.xpath("//h6[text()='Dashboard']");

    By invalidTextBy=By.xpath("//p[text()='Invalid credentials']");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public String dashBoardText() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(d->driver.findElement(dashBoardLabelBy)).isDisplayed();
        String dashboard=driver.findElement(dashBoardLabelBy).getText();
        System.out.println(dashboard);
        return dashboard;

    }
    public String invalidCredentials(){
        String invalidText=driver.findElement(invalidTextBy).getText();
        System.out.println(invalidText);
        return invalidText;
    }
}
