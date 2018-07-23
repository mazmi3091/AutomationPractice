Feature: Testing the functionality of website

@Smoke
Scenario Outline: Search for item and checkout
	Given i am at homepage of site
	When i am typing "<search>" "<searchval>"
	Then i am clicking "<magglass>"	
	And i move mouse to "<overview>"
	Then i am clicking "<addtocart>"
	And i am clicking "<continue>"
	Then i am clicking "<logo>"
	And i am clicking "<twitter>"
	Then i am closing tab
	And i am clicking "<twitteragain>"
	Then i am switching tab
	And i move mouse to "<cart>"
	Then i am clicking "<checkout>"
	And i am clicking "<proceedToCheck>"
	Then i am clicking "<createAcc>"
	And i am printing text "<errorText>"
	Then i am typing "<fakeEmail>" "<emailVal>"
	And i am clicking "<submit>"
	Then i am clicking "<mister>"
	And i am typing "<fname>" "<fnameval>"
	Then i am typing "<lname>" "<lnameval>"
	And i am typing "<pass>" "<passval>"
	Then i am selecting "<day>" "<dayval>"
	And i am selecting "<month>" "<monthval>"	
	Then i am selecting "<year>" "<yearval>"
	And i am clicking "<news>"
	Then i am typing "<address>" "<addval>"
	And i am typing "<city>" "<cityval>"
	Then i am executing "<state>" "<stateval>"
	And i am typing "<zipcode>" "<zipval>"
	Then i am typing "<mobile>" "<mobval>"
	And i am clicking "<register>"
	Then i am clicking "<proceed>"
	And i am clicking "<termsAgree>"
	Then i am clicking "<proceedCar>"
	And i am printing text "<totaltext>"
	Then i am printing text "<total>"
	And i take screenshot "<screen>"
	
	
	Examples:
	|search |searchval |magglass |overview |addtocart |continue |logo |twitter |twitteragain |cart |checkout |proceedToCheck |createAcc |errorText |fakeEmail |emailVal          |submit       |mister |fname |fnameval |lname |lnameval   |pass |passval |day |dayval |month |monthval |year |yearval |news |address |addval     |city |cityval  |state |stateval |zipcode |zipval |mobile |mobval     |register |proceed |termsAgree |proceedCar |totaltext |total |screen ||
	|search |shoes     |magglass |overview |addtocart |continue |logo |twitter |twitteragain |cart |checkout |proceedToCheck |createAcc |errorText |fakeEmail |abc1244@gmail.com |submitButton |mister |fname |Mark     |lname |Zuckerberg |pass |abcd123 |day |22     |month |7        |year |1990    |news |address |1225 67 av |city |new york |state |New York |zipcode |10001  |mobile |3212545152 |register |proceed |termsAgree |proceedCar |totaltext |total |screen ||
	
	