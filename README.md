# Smartpad Automation (Java + Selenium + TestNG)

End-to-end flow for **https://smartpad-customer-feedback.vercel.app**:

1. Open the site  
2. Click **Get started**  
3. Choose **Others**  
4. Click **Continue without an account**  
5. Enter **Wine** in the search bar

## What’s inside

- Java 17, Maven, Selenium 4, TestNG
- Page Object Model (POM)
- WebDriverManager for drivers
- ExtentReports with HTML report under `reports/`
- Screenshots on failure under `screenshots/`
- TestNG listener to auto-capture screenshots and log to report

## Recommended VS Code extensions

- Extension Pack for Java (ms-vscode.extension-pack-java)  
- TestNG Runner (richardwillis.vscode-testng) or use Maven/TestNG from terminal  
- Maven for Java (vscjava.vscode-maven)  
- XML Tools (redhat.vscode-xml)  
- EditorConfig (editorconfig.editorconfig)

## How to run

```bash
# From project root
mvn -q -e -Dtest=com.smartpad.tests.SmartpadFlowTest test
# or run the suite:
mvn -q -Dsurefire.suiteXmlFiles=testng.xml test
```

## Config

Edit `src/test/resources/config.properties`:

```properties
baseUrl = https://smartpad-customer-feedback.vercel.app
browser = chrome
headless = false
implicitWait = 5
explicitWait = 15
```

## Reports & Screenshots

- HTML report: `reports/Smartpad_ExtentReport.html`
- Screenshots on failure: `screenshots/`

## Notes on selectors

Locators are written to be resilient using accessible text (e.g., `//*[normalize-space()='Get started']`).  
If the site changes text/structure, adjust locators in the Page Objects accordingly.
