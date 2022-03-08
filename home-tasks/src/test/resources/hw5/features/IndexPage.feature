Feature: Exercise 1 -  Log section test on Different Elements Page
  Scenario: Log section test on Different elements page
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    And I click on 'Service' button in Header
    And I click on 'Different Elements Page' button in Service dropdown
    When I select 'Water' and 'Wind' checkbox
    And I select 'Selen' radio
    And I select 'Yellow' color in dropdown
    Then For each checkbox, radio, color there is an individual log row and value is corresponded to the status of each of it
