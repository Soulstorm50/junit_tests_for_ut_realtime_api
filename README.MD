# junit_tests_for_ut_realtime_api


    
## Tests structure
---

Response Code tests
1. Проверить что на  sale запрос  с использованием  accountNumber возвращается response code A01;
2. Проверить что на  sale запрос  с использованием  accountNumber возвращается response code D03;
3. Проверить  что    на  sale запрос  с использованием  track data возвращается response code D05;
4. Проверить  что    на  sale запрос  с использованием  track data возвращается response code E02;

AVS Verification tests
5. Проверить что на  sale запрос  с использованием  accountNumber возвращается avsResponseCode 00;
6. Проверить что на  sale запрос  с использованием  accountNumber возвращается avsResponseCode 46;
7. Проверить  что    на  sale запрос  с использованием  track data возвращается avsResponseCode 43;
8. Проверить  что    на  sale запрос  с использованием  track data возвращается avsResponseCode 40;

CSC Verification tests
9. Проверить что на  sale запрос  с использованием  accountNumber возвращается cscResponseCode M;
10. Проверить что на  sale запрос  с использованием  accountNumber возвращается cscResponseCode N;
11. Проверить  что    на  sale запрос  с использованием  track data возвращается cscResponseCode P;
12. Проверить  что    на  sale запрос  с использованием  track data возвращается cscResponseCode S;

 

To run all tests:
    $ mvn clean
    $ mvn test



  
  
 
 

 
