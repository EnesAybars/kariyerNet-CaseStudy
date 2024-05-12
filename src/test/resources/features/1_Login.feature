Feature: Login
  Agile Story: As a user, when I am on the kariyer.net main page
  I Should be able to login with given credentials


  #Positive Case
  @wip
  Scenario: Step1-User should be able to login
    Given user on the home page
    When user clicks the girisYap button
    And user clicks the adaygiris button
    Then user should be on the login page
    When user enters username
    And user enters password
    And user clicks login button
    Then user should be on the account page


  # NOTE1:
  # When user clicks login button after enter credentials,
  # there is geeTest captcha occurs.
  # Which as far as I know can not be automated. So that, we can skip captcha manually in Tests.


  # NOTE2:
  # Here, tests can be extended by negative case scenarios;
  # like invalid credentials or credentials less than 3 chars


