Feature: TC_04

  Scenario: Verify that you are able to compare two products

    Given Click 'mobileButton' HomePage button
    And Add 'Sony Xperia' to compare
    And Add 'IPhone' to compare
    When Click 'Compare' Mobile button
    Then 'Compare Products' popup window containing the selected products: 'Sony Xperia' and 'IPhone' is opened