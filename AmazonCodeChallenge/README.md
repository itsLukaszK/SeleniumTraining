# AmazonCodeChallenge

Test scenario for the Amazon.com website has been prepared using Java + Selenium WebDriver + Cucumber. The test works with Firefox browser. Other browsers support can be implemented if necessary.


The test has been designed to not to fail when the quantity of available products is less than a provided value. In this case maximum available amount of products is added to the cart, even if there is only one item in stock. 

All the WebElements and methods connected with them have been divided to classes connected with pages. Those can be found in classes in the 'pages' package under src/main/java/ directory.

The Cucumber feature file src/test/resources/Amazon.feature contains the scenarios described using Gherkin language. All the steps have been implemented in classes from the src/test/java/cucumber_steps package.


The components required to run the tests are:
- Mozilla Firefox,
- IntelliJ IDEA 2017.3.4 (Community Edition) with the 'Cucumber for Java' version 173.4301 plugin,
- Java Development Kit 9.0.4.

Geckodriver is included in the project.



Please don't hesitate to contact me in case of any questions regarding the scenario. If anything is wrong, I'll be grateful if you inform me about it, as I consider learning from my potential mistakes as valuable. Thank you!
