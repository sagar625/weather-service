# weather-service

To run this application. First run the maven clean and install then build the project and run the application WeatherServiceApplication. We are using H2 in memory database for persistence.

Five endpoints are currently exposed on port 8080. 
***

* We can add a sensor record containing sensorName, Temp, Hum, WS and created_at using the POST method at http://localhost:8080/events/ which can add an entry in the Database using this endpoint. If the created_at is not given in the request body then the defualt value is set to current time.
* we can look at the content of specific sensor using the GET method http://localhost:8080/sensorName e.g. http://localhost:8080/s1.
* we can look at all the sensor records using the GET method  http://localhost:8080/all.
* we can get the avg, min, max, sum of Temprature of any sensor using GET method  http://localhost:8080/all_stats_temp/sensorName e.g  http://localhost:8080/all_stats_temp/s1.
* we can get the avg, min, max, sum of Humidity of any sensor using GET method  http://localhost:8080/all_stats_hum/sensorName e.g  http://localhost:8080/all_stats_hum/s1.
* we can get the avg, min, max, sum of WIndSpeed of any sensor using GET method  http://localhost:8080/all_stats_ws/sensorName e.g  http://localhost:8080/all_stats_ws/s1.
