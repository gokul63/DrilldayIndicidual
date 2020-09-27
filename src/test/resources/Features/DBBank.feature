Feature: Digital Bank

  Background: 
    Given Launch the digital bank application 'http://dbankdemo.com/login' in browser
 
  @test1
  Scenario Outline: To verify application is able to do fund transfer
    When User gets "<TestCaseID>" to perform fundtransfer
    And User enters the userName and password to log in to application
    And User initiate the fund transfer
    And User inputs the senderAccount, receiverAccount and amount to complete  the fund transfer
    Then Verify user completes the fund transfer successfully and log out the application

    Examples: 
      | TestCaseID |
      | DB001      |
      | DB002      |
      | DB003      |
      | DB004      |
      | DB005      |

  @test2
  Scenario Outline: To verify the application is able to perform deposit into account
    When User gets "<TestCaseID>" to perform  deposit into account
    And User enters the userName and password to log in to application
    And User initiates the deposit into account
    And User inputs the accountForDeposit and depositAmount to complete the deposit
    Then Verify user completes the deposit successfully with deposit amount depositAmount
    And User logs out of the application

    Examples: 
      | TestCaseID |
      | DB001      |
