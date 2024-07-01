Feature: Sport tab navigation
  As a user
  I want to navigate to the Sport tab on the Betclic website

  Scenario Outline: Navigate to "<Sport>" tab
    Given I am using Selenium on "<browser>"
    And I am on the Betclic homepage
    When I click on the "<Sport>" tab
    Then the "<Element>" tab should load without errors

    Examples: 
      | browser | Sport    | Element       |
      | chrome  | Futebol  | Toda a oferta |

  Scenario Outline: Select a sport and verify league URL
    Given I am using Selenium on "<browser>"
    And I am on the Betclic homepage
    When I click on the "<Sport>" tab
    And I select the "Brasil - Série A" league
    Then I should be on the "Brasil - Série A" URL

    Examples: 
      | browser | Sport    |
      | chrome  | Futebol  |

  Scenario Outline: Access challenges and verify login page redirection
    Given I am using Selenium on "<browser>"
    And I am on the Betclic homepage
    And I click on "Challenges"
    And I click on the "Aceder" button
    Then I should be redirected to the login page

    Examples: 
      | browser |
      | chrome  |
