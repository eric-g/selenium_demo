package com.selenium.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.pages.ArticlePage;
import com.selenium.pages.BstackPage;

/**
 * Selenium test for Browserstack search
 */
public class AppTest extends BaseTest
{
    /**
     * Rigorous Test :)
     * This test opens the Browserstack website, clicks the search icon,
     * enters a search term, and verifies the N-th search result clicks
     * through to the corresponding article.
     *     
     * @throws InterruptedException 
     */

    @Test
    public void doSomeTesting() throws InterruptedException
    {
        BstackPage bStackPage = new BstackPage(driver);
        bStackPage.openBstack();
        bStackPage.clickSearchIcon();
        WebElement searchInput = bStackPage.getSearchInput();

        Assert.assertEquals(searchInput.getDomAttribute("aria-label"), "Search across browserstack.com");

        bStackPage.closeSearchInput();
        ArticlePage searchResultsPage = bStackPage.searchBy("Selenium WebDriver", 3);
        String headlineText = searchResultsPage.getHeadline();
        System.out.println("Article Headline: " + headlineText);
        Assert.assertEquals(headlineText, bStackPage.searchResult);
    } 
}
