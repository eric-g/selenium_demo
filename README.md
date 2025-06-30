[![Java CI with Maven](https://github.com/eric-g/selenium_demo/actions/workflows/github-actions.yml/badge.svg)](https://github.com/eric-g/selenium_demo/actions/workflows/github-actions.yml)

# WebDriver Demo Project
A simple Selenium WebDriver project demonstrating page object model and GitHub Actions.

## Project Details

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

### CI/CD & Reporting 
- Github Actions enabled (manual at this time) to build and execute test(s) via Maven upon commit/merge PR.
- Allure test result report is published to https://eric-g.github.io/selenium_demo

### Dependencies

- Java 21
- Selenium WebDriver
- TestNG
- Chrome browser

### Run it

$ ```mvn clean test```

