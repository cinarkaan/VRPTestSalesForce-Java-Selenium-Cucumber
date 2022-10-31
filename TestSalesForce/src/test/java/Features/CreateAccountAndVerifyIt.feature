Feature: Account will be created and then verify it was created

  """
  In this feature , The user will be logged in and then he/she will be verified after he was created his account
  """

  Scenario:
    Given : The User will be logged in
    When : Account will be got
    And  : New account will be created
    And : Created account will be verified