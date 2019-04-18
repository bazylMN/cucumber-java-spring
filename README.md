# Cucumber-java-spring template
#### with Cucumber-java8, Cucumber Spring, custom annotation @PageObject, lambda expression ready, Selenide library and session manager (Selenium WebDriver) for:
* ##### chrome

### Prerequisites
* gradle
* Cucumber for Java plugin for IntelliJ
* Gherkin for IntelliJ
* chromedriver.exe (put it into project root)

### Initial
* clone repository
* open build.gradle file in IDE (IntelliJ)
* import dependencies with gradle

### Customise Cucumber tests
* add your .feature files with scenarios
* create custom steps class / steps classes with @Autowired annotations for page objects class / classes
* generate steps- in .feature file press 'alt+enter' shortcut and choose 'Create step definition' option, choose created steps class / steps classes to paste steps
* create custom page objects classes with methods and with @PageObject and @Autowired annotations for webdriver manager
* delete example .feature files, steps classes and page objects classes

### Custom annotation @PageObject
Add @PageObject in page object classes instead of Spring @Component annotation

### Lambda expression ready
Steps classes implements En interface and are prepared to use code by 'lambda-way'. Example of lambda expression is used in SignUpFormPageObjects class:
```
    private void sendKeysForInputWithAttrubuteName(String partValueName, String keyToSend){
        sessionManager.driver().findElements(By.cssSelector(USER_INPUT))
                .stream()
                .filter(elem->elem.getAttribute(USER_INPUT_ATTRIBUTE_NAME).contains(partValueName))
                .findFirst()
                .get()
                .sendKeys(keyToSend);
    }
```

### How to use Selenide
If there is a need to use Selenide to find elements or take action, simply add one line in page object method:
```
WebDriverRunner.setWebDriver(your initialized driver);
```

Method in template, which is using Selenide to find element looks like below:
```
   @PageObject
   public class ActionPageObjects {

       @Autowired
       private SessionManager sessionManager;

       private static final String JAM_MENU = ".Header-nav-item[href*=jam]";

       public void clickJamMenu() {
           WebDriverRunner.setWebDriver(sessionManager.driver());
           $(JAM_MENU).click();
       }
   }
```

### How to run tests:
#### With gradle command:

###### To run Cucumber tests with custom runTests task and with default browser, type:
```
runTests
```

###### To run Cucumber tests with custom runTests task and with chrome, type:
```
-Dbrowser=chrome runTests
```

###### To run Cucumber tests with default browser, type:
```
clean test
```

###### To run Cucumber tests with chrome browser, type:
```
clean -Dbrowser=chrome test
```

#### With IDE (JUnit):
```
run CucumberRunner class
```
```
or run .feature file / directory with .feature files / scenario in .feature file
```

### Reports and screenshots
Reports are placed in 'target' directory, including screenshots of failed scenarios.
To run report in browser, open 'target\html\index.html' file and choose browser.

### Gradle tests reports
Reports are placed in 'build' directory.
To run report in browser, open 'build/reports/tests/runTests/index.html' file and choose browser.

### Gradle custom tasks
* runTests
* deleteCucumberReports
