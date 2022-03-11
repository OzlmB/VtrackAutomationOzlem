
Feature: Login Functionality


  Background:
    Given the user on the login page
  @login @wip
  Scenario Outline: All users log with valid credentials
    Then the user enter <valid username> and <valid password>
    Examples:
      | valid username | valid password |
      | user1          | UserUser123    |
      | storemanager85 | UserUser123    |
      | salesmanager   | UserUser123    |
  @login @wip
  Scenario: After login
    Then "driver" should land on "Quick Launchpad" page after successful login
    Then "storemanager" or "salesmanager" should on "Dashboard" page after successful login
  @login
  Scenario Outline: Entering with invalid credential
    Then the user enters invalid credentials "<invalid username>" and "<invalid password>" and the user can see "Invalid username or password." message
    Examples:
      | invalid username | invalid password |
      | user123          | UserUser123      |
      | store            | Userbghu         |
      | salesmanager101       | abghyt657        |

  @login @opp
  Scenario Outline: entering with blank credentials
    Then the user enters blank credentials "<blank username>" and "<blank password>" and the user can see "Please fill out this field." message
    Examples:
      | blank username | blank password |
      |                |                |


