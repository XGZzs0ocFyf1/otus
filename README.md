## Otus
This project should create program that reads data from url https://raw.githubusercontent.com/mledoze/countries/master/countries.json
and do some manipulations with them. 
I'm using circe parser to get data from json to Objects.

How to use:

**Build**: ```sbt ;clean;assembly``` </br>
**Run**: ```  java -jar target/scala-2.12/hw1.jar homework1``` where homework1 is name of file with program results. Do not add .json extension, it will be generated automatically. </br>
**Check**: in project folder print in console one of variant below: </br>
**powershell**:``` Get-Content .\homework1.json``` (substitute here proper filename instead of homework1.json), </br>
for **cmd** : ```more homework1.json```


####NOTE: This program was created for windows OS and do not tested on linux-like OS. 


