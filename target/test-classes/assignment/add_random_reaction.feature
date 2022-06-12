Feature: Add a random reaction

    As a logged in User,
    I want to add a random reaction to existing post from the default reactions list,
    So that I can use its valuable features

  Background: User is Logged In
    Given I navigate to the login page
    When I submit username and password
    Then I should be logged in

  Scenario: Add a random reaction to existing post
   Given I am on the interview channel page
   And I open a random post
   When I add a random reaction from the default reactions list
   Then I see the random reaction displayed
