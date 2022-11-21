curl --location --request POST 'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAEZEKyLMVJEZhXgVpD3hpgdZNOH3oGBAY' \
--header 'content-type: application/json' \
--data-raw '{
    "email": "kolosovichulia@mail.ru",
    "password": "89392019208",
    "returnSecureToken": true
}'

curl --location --request GET 'http://localhost:8080/app/test' \
--header 'Authorization: Bearer '