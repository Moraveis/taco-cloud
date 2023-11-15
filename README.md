#taco-cloud
http://localhost:9000/oauth2/authorize?response_type=code&client_id=taco-admin-client&redirect_uri=http://127.0.0.1:9090/login/oauth2/code/taco-admin-client&scope=writeIngredients+deleteIngredients

http://127.0.0.1:9090/login/oauth2/code/taco-admin-client?code=mjJBVUwbZZ1ozOIEwi3_Z-MkY3BXSiPjpla0k4xBeYAJXmCb1Bn7XfnO7jCzXCq-SReSiG7ys8l3yjcdIGtUgRARd0sMv6sYQ8LhXENauLlShop-3zu1NBILyT_1qp0D

curl localhost:9000/oauth2/token -H "Content-type: application/x-www-form-urlencoded" -d "grant_type=authorization_code" -d "redirect_uri=http://127.0.0.1:9090/login/oauth2/code/taco-admin-client" -d "code=$code" -u taco-admin-client:secret
{
"access_token": "eyJraWQiOiIyMWY0ZGYwZi00NmJmLTQ0OGQtOWU3Yi1kZDdlNmQxYjczZDEiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0YWNvY2hlZiIsImF1ZCI6InRhY28tYWRtaW4tY2xpZW50IiwibmJmIjoxNjk5NjY4NjA4LCJzY29wZSI6WyJkZWxldGVJbmdyZWRpZW50cyIsIndyaXRlSW5ncmVkaWVudHMiXSwiaXNzIjoiaHR0cDpcL1wvYXV0aHNlcnZlcjo5MDAwIiwiZXhwIjoxNjk5NjY4OTA4LCJpYXQiOjE2OTk2Njg2MDh9.n8t13t8MvN-kxLtYp3Fhl92N1Vt8_7YGgOq7GWW15ikmbddJcj0uijJBtnQK3tN8VoZFEo8gI_xuiTUe5zX_RJLHRrP8pp9fIKarbOpFzNRpiYSp35DaZ7OQj0D-D6BhZaJGqwrqklpCVTwpMtZ4DqpFVmb-9wx-rFwMYuEAKCVo64cG93DwHjySs4phkRpbeSTctGNzLDxweBEOzCvw6U9ioaudpsCc63mwUwJLkNi1VmxS_Ei_b5ZXyXxXz1EfjtIcCXHe8UKwQ1Vc-tGwi-3BeZo3b9tx3irxl308flLbgrUeZKS61bjk759zNv2bFBtwRgePNIP9Z2R1kr2Ynw",
"refresh_token": "viFB0bS3RbiU2flnrVZgagsA_lME3ohhYLLSoO-6YB4dx3CQ9qQVfE5SS7DVkzL1RUbux20pOjcGsnbCD-nWuort75CmlTm0gBHQU8Gu5kKjutwR2pPTMjRoEdfYIrHs",
"scope": "deleteIngredients writeIngredients",
"token_type": "Bearer",
"expires_in": 299
}

curl localhost:8080/ingredients -H "Content-type: application/json" -H "Authorization: Bearer " -d '{"id":"FISH","name":"Stinky Fish", "type":"PROTEIN"}'

curl localhost:9000/oauth2/token -H "Content-type: application/x-www-form-urlencoded" -d "grant_type=refresh_token&refresh_token=HOzHA" -u taco-admin-client:secret

# Docker 
docker run --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management
credentials: guest/guest
