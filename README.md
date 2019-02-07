# Cucumber-java-spring template
#### with Cucumber-java, Cucumber Spring, Selenide library and session manager for:
* ##### chrome (Selenium WebDriver)

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
* create custom page objects classes with methods and with @Component and @Autowired annotations for webdriver manager
* delete example .feature files, steps classes and page objects classes

### How to run tests:
#### With gradle command:

###### To run Cucumber tests with custom runTests task and with default browser, type:
 * 'runTests'

###### To run Cucumber tests with custom runTests task and with chrome, type:
 * '-Dbrowser=chrome runTests'

###### To run Cucumber tests with default browser, type:
* 'clean test'

###### To run Cucumber tests with chrome browser, type:
* 'clean -Dbrowser=chrome test'

#### With IDE (JUnit):
* run CucumberRunner class
* or run .feature file / directory with .feature files / scenario in .feature file

### Reports and screenshots
Reports are placed in 'target' directory, including screenshots of failed scenarios.
To run report in browser, open 'target\html\index.html' file and choose browser.

### Gradle tests reports
Reports are placed in 'build' directory.
To run report in browser, open 'build/reports/tests/runTests/index.html' file and choose browser.

### Gradle custom tasks
* runTests
* deleteCucumberReports
