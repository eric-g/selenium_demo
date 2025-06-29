# WebDriver Demo Project
A simple Selenium WebDriver project demonstrating page object model and GitHub Actions.

`src/test/java/tests/AppTest.java`

- Navigates to Browserstack.com
- Clicks search button
- Checks aria-label, closes search
- Uses ajax search to find articles
- Arrow down in ajax list to N-th article
- Send Enter key to select and visit N-th article page
- Assert ajax article title == actual article title

`src/main/java/pages`

- Models of Browserstack and Article pages.

Dependencies

- Managed by Maven

