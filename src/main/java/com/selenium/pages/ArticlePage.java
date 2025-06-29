package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlePage
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css="h1.guide-banner-section__heading")
    WebElement headline;

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeadline() {
        wait.until(ExpectedConditions.visibilityOf(headline));
        return headline.getText();
    }
    
}
