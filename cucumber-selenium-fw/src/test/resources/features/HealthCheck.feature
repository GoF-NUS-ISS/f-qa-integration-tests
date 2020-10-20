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