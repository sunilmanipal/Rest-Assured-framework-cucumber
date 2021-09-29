Feature: validate Login with accesstoken and getalluser and delete

Scenario: verify Login API

Given  Login API
When Login executes "/user/login" and provide accesstoken
Then successfully executed with status code 200
And verify Login message

Scenario: getalluser
Given Login successfull with accesstoken
When getalluser "/user" and fetch some id
Then verify statuscode

Scenario: deleteuser
Given getallusersuccessfull
When deleteuser "/user/"
Then verify the messgae
