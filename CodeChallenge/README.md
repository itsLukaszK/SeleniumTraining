# CodeChallenge

Five independent test scenarios for the Github.com website have been prepared using Java + Selenium WebDriver + Cucumber. The tests work with Firefox browser. Other browsers support can be implemented if necessary.


The new Github account has been created to make the testing possible. The login data can be found in the SignIn class.

All the WebElements and methods connected with them have been divided to classes connected with pages. Those can be found in classes in the 'pages' package under src/main/java/ directory.

The Cucumber feature file src/test/resources/GithubCom.feature contains the scenarios described using Gherkin language. All the steps have been implemented in classes from the src/test/java/cucumber_steps package.


The components required to run the tests are:
- Mozilla Firefox,
- IntelliJ IDEA 2017.3.4 (Community Edition) with the 'Cucumber for Java' version 173.4301 plugin,
- Java Development Kit 9.0.4.

Geckodriver is included in the project.


Please note I was unable to find the 'Push commits' possibility on the Github.com website, so I've created the scenario connected just with the committing functionality.


Please don't hesitate to contact me in case of any questions regarding the scenarios. If anything is wrong, I'll be grateful if you inform me about it, as I consider learning from my potential mistakes as valuable. Thank you!
