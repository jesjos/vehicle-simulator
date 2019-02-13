[![Build Status](https://travis-ci.org/jesjos/vehicle-simulator.svg?branch=master)](https://travis-ci.org/jesjos/vehicle-simulator)

# Vehicle simulator

Welcome to the vehicle simulator!

## Tasks

1. Checkout the code.
1. See if you can run the tests: `./gradlew build`
1. There are failing tests, make sure they are green.
1. Right now it's impossible to create Cars using web service, correct this. 
    It should be a `POST` request.
1. Create a new entity called `Helicopter`
    1. Helicopters shall have `HelicopterState`
    1. Helicopters can't go down if they've landed
    1. Helicopters can't hover when landed
    1. Enforce these conditions and make sure they are covered by unit tests
1. Create a new controller for Helicopters
    1. It shall be possible to get all helicopters
    1. It shall be possible to create a helicopter (it should be persisted in the database)
    1. It shall be possible to update an existing helicopter
    1. It shall be possible to get a particular helicopter by id
1. Take care to format your code correctly and consistently
1. Commit your changes with well formed commit messages
1. Bonus: test all requests using [MockMVC](https://spring.io/guides/gs/testing-web/)
1. Bonus: create a shell script that starts the application and creates Car with name "foo". 
1. Fork this repo, create a pull request to it. Make sure the travis-ci job goes green.

## Running the application 
To run the application, execute the following command:

```bash
$ ./gradlew bootRun
```

This will start a webserver at http://localhost:8080

Try making a GET request to http://localhost:8080/vehicles

## Tips
To perform GET requests you can use the browser. For POST, try for example [Postman](https://www.getpostman.com/)
