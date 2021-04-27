# Push Notification Service For Push Bullet #

## Dependencies ##
  * Java 11
  * Maven 3.8.1

## Run locally ##
Run command `java - jar PushBulletApi.jar` in the top directory. This will run on
default `http://localhost:8080`.
You can change the port number by passing in `-Dserver.port=<port number>`

If your running this in your IDE you can change the port number in the `application.properties` file. e.g `server.port=5000`.

Note you will need Spring note you may need the spring web jar if you are running this in your
IDE. You can download this [here](https://start.spring.io/) and run as a spring boot app.



curl -d "{"username": "Yusuf", "accessToken": "o.8okVfbrBr0LhX5sNibukanz9362YCVYM"}" -X POST http://localhost:8080/create


## Http Requests ##
To send requests you can use [postman](https://www.postman.com/downloads/).


**Post** request body example:
  Updates local API with user.

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Using url `http://localhost:8080/create`

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  `
  {
      "username": "Yusuf",
      "accessToken": "o.8okVfbrBr0LhX5sNibukanz9362YCVYM"
  }
  `
_____________________________________________________________

**Get** get all request:
Using url `http://localhost:8080/getAll`

example response

`{
  "accessToken": "access",
  "creationTime": "2021-04-27T15:26:37",
  "numOfNotificationsPushed": 0,
  "username": "Yusuf"
}`
_____________________________________________________________
**Put**

User name must exist.

Using url  `http://localhost:8080/push`

`{
    "username": "Yusuf",
    "title": "Yusuf has sent you a message",
    "message": "hello world"
}`

## To do ##
* Add exception handling for put request fails.
* Create API contract / documentation.
* Validation for incoming request.
* Add unit testing
