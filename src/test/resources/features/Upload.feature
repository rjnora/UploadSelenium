@feature.upload
Feature: Upload

Scenario: Upload successfully
  Given I open website Upload Heroku
  When I choose file
  Then I click upload file
  And I should see file