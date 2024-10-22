Feature: User Registration

  As a user
  I want to register for the application
  So that I can create an account

  Background:
    Given the registration page is displayed

  Scenario: Password is valid with minimum 6 characters, one number, and one special character
    When the user enters "Petar" in the First Name field
    And the user enters "Tsolov" in the Surname field
    And the user enters "1" in the Day field
    And the user enters "May" in the Month field
    And the user enters "1999" in the Year field
    And the user enters "example@example.com" in the Email Address field
    And the user enters "1234567890" in the Telephone field
    And the user enters "0987654321" in the Mobile field
    And the user enters "123 Street" in the Address Line 1 field
    And the user enters "Sofia" in the City field
    And the user enters "Bulgaria" in the County field
    And the user enters "1000" in the Postcode field
    And the user enters "Bulgaria" in the Country field
    And the user chooses "ptsolov" as the username
    And the user enters "Password0)" as the password
    And the user re-types "Password0)" in the Re-type Password field
    And the user selects a security question "What was your childhood nickname" with answer "pesho"
    And the user selects a security question "What is your favorite color?" with answer "green"
    And the user selects "US Dollars" as the currency
    And the user accepts terms and conditions
    Then the registration is successful

  Scenario: Password is too short
    When the user enters "Petar" in the First Name field
    And the user enters "Tsolov" in the Surname field
    And the user enters all other valid registration details
    And the user enters "Pa$5" as the password
    Then an error message "The minimum length is 6 characters" is displayed

  Scenario: Password does not contain a number
    When the user enters "Petar" in the First Name field
    And the user enters "Tsolov" in the Surname field
    And the user enters all other valid registration details
    And the user enters "Passw!" as the password
    And the user re-types "Passw!" in the Re-type Password field
    Then an error message "Confirm password required" is displayed

  Scenario: Password does not contain a special character
    When the user enters "Petar" in the First Name field
    And the user enters "Tsolov" in the Surname field
    And the user enters all other valid registration details
    And the user enters "Password1" as the password
    And the user re-types "Password1" in the Re-type Password field
    Then the registration is successful
    And an error message "Page not found" is displayed
    And an error message "Sorry an unexpected error has occured. Please try again." is displayed

  Scenario: Passwords do not match
    When the user enters "Petar" in the First Name field
    And the user enters "Tsolov" in the Surname field
    And the user enters all other valid registration details
    And the user enters "Passw0rd!" as the password
    And the user re-types "Passw0rd123!" in the Re-type Password field
    Then an error message "Both fields must match" is displayed