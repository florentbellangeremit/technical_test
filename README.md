# Offer_technical_test

## Build and run the app

```./gradlew build```

```./gradlew run```

## DataBase

http://localhost:8080/h2-console

## Routes

#### POST /user

Body example :

```
{
    "username":"e",
    "country":"FRA",
    "birthdate": "2004-12-10T13:45:00.000Z",
    "gender":"MALE",
    "phoneNumber":"06-05-05-05-05"
}
```

Response : 201

If in the body, the country is not FRA:

Response: 400 Bad request
Message : Country must be FRA

If the user have less than 18 years old:

Response: 400 Bad request
Message : You must have at least 18 years old

#### GET /user/{id}

Response:

```
{
    "username":"e",
    "country":"FRA",
    "birthdate": "2004-12-10T13:45:00.000Z",
    "gender":"MALE",
    "phoneNumber":"06-05-05-05-05"
}
```

