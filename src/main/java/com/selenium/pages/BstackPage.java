package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BstackPage {
    WebDriver driver;

    @FindBy(css = "button.hide-xs[aria-label='Search']")
    WebElement searchIcon;

    @FindBy(xpath = "//input[@id='doc-search-box-input']")
    WebElement searchInput;

    By closeSearchInput = By.xpath("//button[@aria-label='Close Search Filter']");
    public String searchResult;

    public BstackPage(WebDriver driver) {
        this.driver = driver;
        this.searchResult = "";
        PageFactory.initElements(this.driver, this);
    }

    public void openBstack() {
        driver.get("https://www.browserstack.com");
    }

    public void clickSearchIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon));

        Actions action = new Actions(driver);
        // Performing the mouse hover action on the target element.
        action.moveToElement(searchIcon).perform();
        searchIcon.click();
    }

    public WebElement getSearchInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        return searchInput;
    }

    public void closeSearchInput() {
        driver.findElement(closeSearchInput).click();
    }

    private WebElement getSearchResultN(int n) {
        By searchResult = By.xpath("//*[@id=\"global-search-autocomplete\"]/a["+ n + "]/div[1]/div[1]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement searchResultElement = wait.until(ExpectedConditions.elementToBeClickable(searchResult));
        return searchResultElement;
    }

    /**
     * Searches for the given text and clicks on the specified result.
     *
     * @param searchText   The text to search for.
     * @param clickResult  The index of the result to click (0 for first result).
     * @return SearchResultPage object representing the search results page.
     * @throws InterruptedException if the thread is interrupted during sleep.
     */
    public ArticlePage searchBy(String searchText, int clickResult) throws InterruptedException {
        if (!searchInput.isDisplayed()) {
            clickSearchIcon();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        
        searchInput.sendKeys(searchText);

        if (clickResult == 0) {
            searchInput.sendKeys(Keys.ENTER);
        } else {
            searchInput.sendKeys(Keys.ARROW_DOWN);
            WebElement searchAutocomplete;

            for (int i = 0; i <= clickResult; i++) {
                searchAutocomplete = driver.switchTo().activeElement();
                searchAutocomplete.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(500); // todo: find better wait for the autocomplete to update
            }
            
            WebElement searchResult = getSearchResultN(clickResult);
            System.out.println("Search Result: " + searchResult.getText());
            this.searchResult = searchResult.getText();
            searchAutocomplete = driver.switchTo().activeElement();
            searchAutocomplete.sendKeys(Keys.ENTER);
        }
        
        // return new initialized ArticlePage
        return new ArticlePage(driver);
    }
  
}
