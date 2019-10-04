Feature: Login to QAClickAcademy 

Scenario Outline: Login successfully 
	Given Open Chrome browser 
	And Go to "http://www.qaclickacademy.com" 
	And Go to Login page 
	When Input username <user> and password <pass> 
	And Click on Login button 
	Then Redirect to Learning page and Verify Searchbox 
	And Close browser 
	
	Examples: 
		| user             | pass   | 
		| test99@gmail.com | 123456 | 
		| tst99@gmail.com  | 983456 | 
