Feature: Add event Functionality

Scenario:Marking the event with any color
Given the user is logged in as "store manager"
And  go to from "Fleet" to "Vehicle" module
When clicking on any vehicle
And  clicking on "Add event" button
And  the user can mark the event with any color


Scenario:"All-day event" button
Given the user is logged in as "store manager"
And  go to from "Fleet" to "Vehicle" module
When clicking on any vehicle
And  clicking on "Add event" button
And the user can mark "All day event" button


Scenario:Repeating the action by specifying occurrence periods and ending time
Given the user is logged in as "store manager"
And  go to from "Fleet" to "Vehicle" module
When clicking on any vehicle
When clicking on "Add event" button
Then Repeat option should includes the options below
| Daily   |
| Weekly  |
| Monthly |
| Yearly  |

Scenario:Repeating the action by specifying occurrence periods and ending time
Given the user is logged in as "store manager"
And  go to from "Fleet" to "Vehicle" module
When clicking on any vehicle
When clicking on "Add event" button
Then Ends option should be as below
| Never |
| After |
| By    |
And Ends options should be clickable

  @Ozl

Scenario: Verify the "All Events"
Given the user is logged in as "store manager"
And  go to from "Fleet" to "Vehicle" module
When clicking on any vehicle
Then All Users can see all events in the General information page



