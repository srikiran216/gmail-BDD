Feature: Gmail Login
Scenario: validate title
Given launch gmail site
Then validate title with "Gmail" value
And close site

Scenario Outline: validate User ID
Given launch gmail site
When enter userid with "<x>" value
And click next button
Then validate userid field with "<y>" value
And close site
Examples:
					|      x        |        y        |
					| srikiran216   |     valid       |
					| srikirsghkj   |    invalid      |
					|               |     blank       |

Scenario Outline: validate password 
Given launch gmail site
When enter userid with "srikiran216" value
And click next button
And enter password with "<pwd>" value
And click password next button
Then validate password field with "<criteria>" value
And close site
Examples:
					|      pwd       |     criteria    |
					|xxxxxxxxxxxxxxxx|     valid       |
					| srikirsghkj    |    invalid      |
					|                |     blank       |

					

