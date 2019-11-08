#Weather Forecast Project

### Presentation :

Le project est un web service REST qui va consumer l'API suivante : https://openweathermap.org/appid afin de recuperer les previsions meteorologique du jour plus les 4 jours à venir selon une intervale de 3 heures.

### Utilisation :

Pour faire un appel au ws il faut executer l'URL avec les parametre suivants :
````
host:port/weather/{nom_de_la_ville}
````
Exemple : localhost:8082/weather/rainyDays/Lens

Résultat en format JSON :
````
[
  "2019-11-09 01:00",
  "2019-11-11 16:00",
  "2019-11-11 19:00",
  "2019-11-12 07:00",
  "2019-11-12 04:00"
]

````
