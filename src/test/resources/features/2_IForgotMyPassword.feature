Feature: I Forgot My Password
  Agile Story: As a user, when I forgot my username or password
  I should be able to change my credentials by clicking I forgot my password link


  Background:
    Given user on the login page
    When user click I Forgot My Password link
    Then user should on I forgot my password page

  @wip
  Scenario: Step-1 forgotMYPass with email
    When user clicks email button
    And user enters emailEmail
    And user clicks send button for email
    Then user should see reset link sent page

  @wip
  Scenario: Step-2 forgotMYPass with phoneNumber
    When user clicks phone button
    And user enters emailPhone
    And user enters lastName
    And user enter phoneNumber
    And user clicks send button for phone
    Then user should see reset link sent page

