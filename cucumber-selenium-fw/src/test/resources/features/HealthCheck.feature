@ui @healthcheck
Feature: Travel Plan UI is Health Check

  Scenario: User is able to Open the browser, navigate to the URL and Login with Credentials
    Given User navigated to the home application url
    When User enter username
    And User enter password
    And User click on Sign Button
    Then User is able to login in to the Application

  Scenario: User not able to login if using invalid credentials
    Given User navigated to the home application url
    When User enter wrong username
    And User enter wrong password
    And User click on Sign Button
    Then User is not logged in and application displayes error message as "User does not exist."

  Scenario: User is able to Create new Plan
    Given User navigated to the home application url
    And User enter username
    And User enter password
    And User click on Sign Button
    And User is able to login in to the Application
    When User click on "Create Plan" Link
    And User fill the form with below details
      | TITLE         | DATE       | FROM | TO    | STARTING_ON | RETURNING_ON | COST | MODE_OF_TRASPORT |
      | Plan to Japan | 12-12-2020 | SGP  | JAPAN | 12-12-2020  | 25-12-2020   | 500  | FLIGHT           |
    Then User plan is created
    And User Plan is displayed under "View Existing" Plan Page


