Feature: password change

  Scenario: correctly fills out change form should see confirmation notification
    Given existing user credentials are "moonraytest@gmail.com" and "L1fetw1g@22!"
    And new password is "L1fetw1g@22"
    When existing user logs in and lands on security page
    And correctly fills out change form
    Then password change notification is displayed