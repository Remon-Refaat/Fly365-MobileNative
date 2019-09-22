
Feature: Search for trips and assert on search results

  Scenario: Verify that the user can search successfully
    Given Select "One Way" trip
    And Add airport to the Origin "Cairo International Airport"
    And Add airport to the Destination "Auckland International"
    And Select the date of the departure, after "10" day from today
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Select "Premium" Class
    And Press on Search Now