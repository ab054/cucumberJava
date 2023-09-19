# Author Dmitrii V

@openCircle
Feature: Open Circe

  @openCircle
  Scenario: Open Circle album validation
    Given open login page
      # Authorized user sign in
    When type valid credentials
      # Loged in user have access to albums
    And user opens albums
    Then album is present in list

  @openCircle
  Scenario: Open Circle create Topic
    Given open login page
    When type valid credentials
      # Create new topic
    And user creates topic
    Then create topic success message displayed

  @openCircle
  Scenario: Open Circle delete Topic
    Given open login page
    When type valid credentials
      # Delete topic
    And user deletes topic
    Then confirmation message is displayed

  @openCircle
  Scenario: Open Circle first and last names confirmation
    Given open login page
    When type valid credentials
      # First and last names confirmation
    And open user profile
    Then first and last names are verified

  @openCircle
  Scenario: Open Circle user logs out
    Given open login page
    When type valid credentials
      # User logs out
    And open user profile
    And user logs out
    Then login page is displayed

  @openCircle
  Scenario: Open Circle user can not change password to less then 8 char
    Given open login page
      # Authorized user sign in
    When type valid credentials
    Then circle name is displayed
      # Loged in user opens profile page
    Then open user profile
    Then change password with 6 char
    Then change psw error message displayed
