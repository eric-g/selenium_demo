package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest2 extends BaseTest { 
    
    @FindBy(xpath = "//*[@id='doc-search-box-input']")
    WebElement searchInput;

    @FindBy(css = "button.hide-xs[aria-label='Search']")
    WebElement searchIcon;
    
    // Note this test doesn't actually work.
    //@Test
    public void test() {
        driver.get("https://www.browserstack.com");
        PageFactory.initElements(driver, this); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        searchIcon.click();
        searchIcon.click();

        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.sendKeys("Selenium WebDriver");

        WebElement element = driver.findElement(By.linkText("Sign Up"));
        element.click();
        searchInput.sendKeys("Selenium WebDriver");
    }

    
}
