Feature: Amazon

  Scenario: Add products to the shopping cart
    Given User is visiting 'https://www.amazon.com/' site
    When User goes into Best Sellers in Digital Cameras
    And User opens details of product number '5' from the list and gets the name of the product
    And User adds '8' or maximum available number of pieces of the product to the shopping cart and gets the price of the product
    Then The correct product was added
    And The subtotal price sum is correct