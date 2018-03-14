Feature: Hotels end to end tests

  @hotel@1
  Scenario: Check the confirmation screen

    Given user is in landing page
    When he filter the hotels with location as "London"
    Then he should see the results
    And selects the first hotel in the list
    Then he should view the hotels details
    When he selects the first rooms available
    And go to payment page
    Then he should see payment page
    When he pay with default payment method
    Then he should see the booking confirmation


  @hotel@1
  Scenario Outline: Check the confirmation screen for other languages

    Given user is in landing page for "<market>"
    When he filter the hotels with location as "london"
    Then he should see the results
    And selects the random hotel in the list
    Then he should view the hotels details
    When he selects the random rooms available
    And go to payment page
    Then he should see payment page
    When he pay with default payment method
    Then he should see the booking confirmation with message "<message>"

    Examples:

      | market | message                         |
      | uk-en  | Your booking is confirmed       |
      | fr-fr  | Votre réservation est confirmée |
      | be-nl  | De boeking is bevestigd         |
      | nl-nl  | De boeking is bevestigd         |
      | be-fr  | Votre réservation est confirmée |
      | be-en  | Your booking is confirmed       |




  @hotel@4
  Scenario Outline: Check the confirmation screen with different payment types

    Given user is in landing page for "<market>"
    When he sets location as "<location>"
    Then he sets start date as "<startdate>"
    And set the duration as "<duration>"
    And set the room and pax
      | 1 | <room1> |
      | 2 | <room2> |
    And load the URL
    And selects the first hotel in the list
    Then he should view the hotels details
    When he selects the first rooms available
    And go to payment page
    Then he should see payment page
    When he pay with default payment method
    Then he should see the booking confirmation with message "<message>"


    Examples:
      | market | location | startdate | duration | room1  | room2  |message|
#      | uk-en  | london   | 5         | 3        | 1A1Y1C1I |  | Your booking is confirmed      |
      | uk-en  | london   | 100       | 1        | 1A     |        | Your booking is confirmed      |
      | uk-en  | london   | 50        | 3        | 2A     | 2A     |Your booking is confirmed       |
      | uk-en  | london   | 5         | 3        | 1A1Y1C | 1A1Y1C | Your booking is confirmed      |
      | nl-nl  | london   | 100       | 1        | 1A     |        |De boeking is bevestigd|
      | nl-nl  | london   | 50        | 3        | 2A     | 2A     |De boeking is bevestigd|
      | nl-nl  | london   | 5         | 3        | 1A1Y1C | 1A1Y1C |De boeking is bevestigd|
      | be-en  | london   | 100       | 1        | 1A     |        |Your booking is confirmed|
      | be-en  | london   | 50        | 3        | 2A     | 2A     |Your booking is confirmed|
      | be-en  | london   | 5         | 3        | 1A1Y1C | 1A1Y1C |Your booking is confirmed|
      | be-fr  | london   | 100       | 1        | 1A     |        |Votre réservation est confirmée|
      | be-fr  | london   | 50        | 3        | 2A     | 2A     |Votre réservation est confirmée|
      | be-fr  | london   | 5         | 3        | 1A1Y1C | 1A1Y1C |Votre réservation est confirmée|
      | be-nl  | london   | 100       | 1        | 1A     |        |De boeking is bevestigd|
      | be-nl  | london   | 50        | 3        | 2A     | 2A     |De boeking is bevestigd|
      | be-nl  | london   | 5         | 3        | 1A1Y1C | 1A1Y1C |De boeking is bevestigd|


    @hotel
  Scenario Outline: Check the confirmation screen with different payment types

    Given user is in landing page for "<market>"
    When he filter the hotels with location as "amsterdam"
    Then he should see the results
#    And selects the random hotel in the list
    And selects the first hotel in the list
    Then he should view the hotels details
    When he selects the random rooms available
    And go to payment page
    Then he should see payment page
    When he pay with card "<card number>" and 3ds "<3ds>"
    Then he should see the booking confirmation with message "<message>"
  @hotel@1
    Examples:

      | market | message                   | card type         | card number      | 3ds   | results | refid   |
      | uk-en  | Your booking is confirmed | Visa Electron     | 4937370000000015 | false | pass    | 1561135 |
      | uk-en  | Your booking is confirmed | Visa Electron     | 4937370000000015 | true  | pass    | 1561091 |
      | uk-en  | Your booking is confirmed | Amex              | 374290482911992  | false | pass    | 1561137 |
      | uk-en  | Your booking is confirmed | Amex              | 374290482911992  | true  | pass    | 1561093 |
      | uk-en  | Your booking is confirmed | Mastercard credit | 5255000000000019 | false | pass    | 1561095 |
      | uk-en  | Your booking is confirmed | Mastercard credit | 5255000000000019 | true  | pass    | 1561097 |
      | uk-en  | Your booking is confirmed | Visa Credit       | 4929498311405001 | false | pass    | 1561138 |
      | uk-en  | Your booking is confirmed | Visa Credit       | 4929498311405001 | true  | pass    | 1561153 |
      | uk-en  | Your booking is confirmed | Debit Mastercard  | 5573480000000190 | false | pass    | 1561154 |
      | uk-en  | Your booking is confirmed | Debit Mastercard  | 5573480000000190 | true  | pass    | 1561102 |
      | fr-fr  | Votre réservation est confirmée | Visa Electron     | 4937370000000015 | false |pass|1561107|
      | fr-fr  | Votre réservation est confirmée | Visa Electron     | 4937370000000015 | true  |pass|1561108|
      | fr-fr  | Votre réservation est confirmée | Amex              | 374290482911992  | false | pass    |   1561155    |
      | fr-fr  | Votre réservation est confirmée | Amex              | 374290482911992  | true  | pass    |  1561165     |
      | fr-fr  | Votre réservation est confirmée | Mastercard credit | 5255000000000019 | false | pass    |  1561156     |
      | fr-fr  | Votre réservation est confirmée | Mastercard credit | 5255000000000019 | true  |pass|1561116|
      | fr-fr  | Votre réservation est confirmée | Visa Credit   | 4929498311405001 | false | pass    |  1561176       |
      | fr-fr  | Votre réservation est confirmée | Visa Credit       | 4929498311405001 | true  |pass   | 1561142    |
      | fr-fr  | Votre réservation est confirmée | Debit Mastercard  | 5573480000000190 | false |pass   | 1561143    |
      | fr-fr  | Votre réservation est confirmée | Debit Mastercard  | 5573480000000190 | true  |pass   | 1561144    |
      | nl-nl  | De boeking is bevestigd   | Visa Electron     | 4937370000000015 | false | pass    | 1561170 |
      | nl-nl  | De boeking is bevestigd   | Visa Electron     | 4937370000000015 | true  | pass    | 1561172 |
      | nl-nl  | De boeking is bevestigd   | Amex              | 374290482911992  | false | fail    | 1561164 |
      | nl-nl  | De boeking is bevestigd   | Amex              | 374290482911992  | true  | pass    | 1561120 |
      | nl-nl  | De boeking is bevestigd   | Mastercard credit | 5255000000000019 | false | pass    | 1561121 |
      | nl-nl  | De boeking is bevestigd   | Mastercard credit | 5255000000000019 | true  | pass    | 1561127 |
      | nl-nl  | De boeking is bevestigd   | Visa Credit       | 4929498311405001 | false | pass    | 1561130 |
      | nl-nl  | De boeking is bevestigd   | Visa Credit       | 4929498311405001 | true  | pass    | 1561173 |
      | nl-nl  | De boeking is bevestigd   | Debit Mastercard  | 5573480000000190 | false | pass    | 1561149 |
      | nl-nl  | De boeking is bevestigd   | Debit Mastercard  | 5573480000000190 | true  | pass    | 1561150 |

  @hotel@2
    Examples:

      | market | message                         | card type         | card number      | 3ds   | results | refid   |
      | be-en  | Your booking is confirmed       | Visa Electron     | 4937370000000015 | false | pass    | 1561135 |
      | be-en  | Your booking is confirmed       | Visa Electron     | 4937370000000015 | true  | pass    | 1561091 |
      | be-en  | Your booking is confirmed       | Amex              | 374290482911992  | false | pass    | 1561137 |
      | be-en  | Your booking is confirmed       | Mastercard credit | 5255000000000019 | false | pass    | 1561095 |
      | be-en  | Your booking is confirmed       | Mastercard credit | 5255000000000019 | true  | pass    | 1561097 |
      | be-en  | Your booking is confirmed       | Visa Credit       | 4929498311405001 | false | pass    | 1561138 |
      | be-en  | Your booking is confirmed       | Visa Credit       | 4929498311405001 | true  | fail    |         |
      | be-en  | Your booking is confirmed       | Debit Mastercard  | 5573480000000190 | false | fail    |         |
      | be-fr  | Votre réservation est confirmée | Visa Electron     | 4937370000000015 | false | pass    | 1561107 |
      | be-fr  | Votre réservation est confirmée | Visa Electron     | 4937370000000015 | true  | pass    | 1561108 |
      | be-fr  | Votre réservation est confirmée | Amex              | 374290482911992  | false | fail    |         |
      | be-fr  | Votre réservation est confirmée | Mastercard credit | 5255000000000019 | false | fail    |         |
      | be-fr  | Votre réservation est confirmée | Mastercard credit | 5255000000000019 | true  | pass    | 1561116 |
      | be-fr  | Votre réservation est confirmée | Visa Credit       | 4929498311405001 | false | fail    |         |
      | be-fr  | Votre réservation est confirmée | Visa Credit       | 4929498311405001 | true  | pass    | 1561142 |
      | be-fr  | Votre réservation est confirmée | Debit Mastercard  | 5573480000000190 | false | pass    | 1561143 |
      | be-fr  | Votre réservation est confirmée | Debit Mastercard  | 5573480000000190 | true  | pass    | 1561144 |
      | be-nl  | De boeking is bevestigd         | Visa Electron     | 4937370000000015 | false | fail    |         |
      | be-nl  | De boeking is bevestigd         | Visa Electron     | 4937370000000015 | false | fail    |         |
      | be-nl  | De boeking is bevestigd         | Amex              | 374290482911992  | false | fail    |         |
      | be-nl  | De boeking is bevestigd         | Mastercard credit | 5255000000000019 | false | pass    | 1561121 |
      | be-nl  | De boeking is bevestigd         | Mastercard credit | 5255000000000019 | true  | pass    | 1561127 |
      | be-nl  | De boeking is bevestigd         | Visa Credit       | 4929498311405001 | false | pass    | 1561130 |
      | be-nl  | De boeking is bevestigd         | Visa Credit       | 4929498311405001 | true  | fail    |         |
      | be-nl  | De boeking is bevestigd         | Debit Mastercard  | 5573480000000190 | false | pass    | 1561149 |
      | be-nl  | De boeking is bevestigd         | Debit Mastercard  | 5573480000000190 | true  | pass    | 1561150 |
