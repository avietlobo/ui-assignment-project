Feature: Add a new post

    As a logged in User,
    I want to edit a new post,
    So that I can publish it as an announcement expiring one week later

  Background: User is Logged In
    Given I navigate to the login page
    When I submit username and password
    Then I should be logged in

  Scenario: Add a new post and publish it as an announcement expiring one week later
    Given I am on the interview channel page
    When I edit a new post
    Then I should be able to publish it as announcement
