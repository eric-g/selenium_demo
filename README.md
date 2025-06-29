# WebDriver Demo Project
A simple Selenium WebDriver project demonstrating page object model and GitHub Actions.

## Project

`src/test/java/tests/AppTest.java`

- Navigates to Browserstack.com
- Clicks search button
- Checks aria-label, closes search
- Re-opens search
- Search to find articles about 'Selenium Webdriver'
- Arrow down in ajax list to N-th article
- Send Enter key to select and visit N-th article page
- Assert ajax article title selected  == actual article title shown

`src/main/java/pages`

- Models of Browserstack and Article pages.

### Dependencies

- Java 21
- Selenium WebDriver
- TestNG
- Chrome browser

### Run it

$ ```mvn clean test```

