# BOSCH-ASSIGNMENT

Every Resource end points are protected by Spring security & JWT token

Use POST:http://localhost:8080/employee-service/authenticate and boday as either below, to get the access token.

{
    "username":"Santhosh",
    "password":"dummy"
}
or 
{
    "username":"Sudheesh",
    "password":"dummy"
}

The Token Should be passed as Bearer tokenvalue to get authorized access to rest of the resources
PFA Sample postman colletion json file for to get more info on the different end points
