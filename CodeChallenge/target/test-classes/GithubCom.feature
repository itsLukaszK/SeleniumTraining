Feature: Github.com

  @DeleteAndQuitAfter
  Scenario: Creating a repository
    Given User is logged in
    When User creates a repository called 'QQXli0cANyOYujUmBJ7jtIwM17fLPWtX-xrAKzkl1uJ4UKqXXI-U63Vx7Yk8QkvNWBDNz7iTQxWusHikLlUCmFK2yJB1zFuVMVV4' containing ReadMe
    # ^ Max name length = 100
    Then The repository has been created

  @DeleteAndQuitAfter
  Scenario: Committing
    Given User is logged in
    When User creates a repository called 'QQXli0cANyOYujUmBJ7jtIwM17fLPWtX-xrAKzkl1uJ4UKqXXI-U63Vx7Yk8QkvNWBDNz7iTQxWusHikLlUCmFK2yJB1zFuVMVV4' containing ReadMe
    And User changes the name of the 'README.md' file to 'READMEupdate.md' and chooses 'Commit directly to the master branch.'
    Then The changes have been committed

  @DeleteAndQuitAfter
  Scenario: Creating Pull Request
    Given User is logged in
    When User creates a repository called 'QQXli0cANyOYujUmBJ7jtIwM17fLPWtX-xrAKzkl1uJ4UKqXXI-U63Vx7Yk8QkvNWBDNz7iTQxWusHikLlUCmFK2yJB1zFuVMVV4' containing ReadMe
    And User changes the name of the 'README.md' file to 'READMEupdate.md' and chooses 'Create a new branch for this commit and start a pull request.'
    And User creates pull request
    Then The pull request has been created

  @DeleteAndQuitAfter
  Scenario: Accepting Pull Request
    Given User is logged in
    When User creates a repository called 'QQXli0cANyOYujUmBJ7jtIwM17fLPWtX-xrAKzkl1uJ4UKqXXI-U63Vx7Yk8QkvNWBDNz7iTQxWusHikLlUCmFK2yJB1zFuVMVV4' containing ReadMe
    And User changes the name of the 'README.md' file to 'READMEupdate.md' and chooses 'Create a new branch for this commit and start a pull request.'
    And User creates pull request
    And User accepts pull request
    Then The pull request has been accepted

  @QuitAfter
  Scenario: Deleting a repository
    Given User is logged in
    When User creates a repository called 'QQXli0cANyOYujUmBJ7jtIwM17fLPWtX-xrAKzkl1uJ4UKqXXI-U63Vx7Yk8QkvNWBDNz7iTQxWusHikLlUCmFK2yJB1zFuVMVV4' containing ReadMe
    And User deletes the created repository
    Then The repository has been deleted

