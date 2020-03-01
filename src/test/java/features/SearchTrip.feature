
Feature: Search for trips and assert on search results
@test
  Scenario: Verify that the user can search successfully
    Given Select "One Way" trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dubai (DXB), United Arab Emirates"
    And Select the date of the departure, after "10" day from today
    And Select Passengers: "1" adult, "1" child, "0" infant
#    And Select "Premium" Class
    And Press on Search Now
    And Choose a trip
    And Press on Continue Button
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Birthday |
      | Mr    | John       | William     | Smith     | 15 Jan 2008  |
      | Mr    | John       | William     | Oliver    | 15 Jan 2016  |
    And Add the following data in the Contact Details
      | Title | First Name | Last Name | Email                        | Phone Number|
      | Mr    | John      | Smith      | john.smith.fly365@gmail.com  |01201063729      |
    And Click on CONTINUE