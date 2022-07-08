Feature: Login
  As a web user i want to get on the web site as soon as i type my credentials

  @Success
  Scenario: login success full
    Given  i on the login page
    When  I type my credentials
    Then  i should get on the website