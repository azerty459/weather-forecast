#Weather Forecast Project

### Presentation :

Le project est un web service REST qui va consumer l'API suivante : https://openweathermap.org/appid afin de recuperer les previsions meteorologique du jour et des 4 jours à venir selon une intervale de 3 heures.

### Utilisation :

Pour faire un appel au ws il faut executer l'URL avec les parametre suivants :
````
host:port/weather/{nom_de_la_ville, code_pays}
````
Exemple : localhost:8080/weather/Lens,fr

Résultat en format JSON :
````
{
  "detail": [
    {
      "dateTime": "30/10/19 13:00",
      "main": {
        "temperature": 281.2,
        "temperature_minimal": 281.2,
        "temperature_maximal": 281.37,
        "humidite": 71
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10d"
        }
      ]
    },
    {
      "dateTime": "30/10/19 16:00",
      "main": {
        "temperature": 282.26,
        "temperature_minimal": 282.26,
        "temperature_maximal": 282.39,
        "humidite": 71
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04d"
        }
      ]
    },
    {
      "dateTime": "30/10/19 19:00",
      "main": {
        "temperature": 280.38,
        "temperature_minimal": 280.38,
        "temperature_maximal": 280.46,
        "humidite": 78
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "broken clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "30/10/19 22:00",
      "main": {
        "temperature": 279.24,
        "temperature_minimal": 279.24,
        "temperature_maximal": 279.28,
        "humidite": 83
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "broken clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "31/10/19 01:00",
      "main": {
        "temperature": 278.0,
        "temperature_minimal": 278.0,
        "temperature_maximal": 278.0,
        "humidite": 84
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "31/10/19 04:00",
      "main": {
        "temperature": 277.18,
        "temperature_minimal": 277.18,
        "temperature_maximal": 277.18,
        "humidite": 84
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "31/10/19 07:00",
      "main": {
        "temperature": 276.99,
        "temperature_minimal": 276.99,
        "temperature_maximal": 276.99,
        "humidite": 85
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "31/10/19 10:00",
      "main": {
        "temperature": 279.01,
        "temperature_minimal": 279.01,
        "temperature_maximal": 279.01,
        "humidite": 79
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04d"
        }
      ]
    },
    {
      "dateTime": "31/10/19 13:00",
      "main": {
        "temperature": 282.87,
        "temperature_minimal": 282.87,
        "temperature_maximal": 282.87,
        "humidite": 72
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04d"
        }
      ]
    },
    {
      "dateTime": "31/10/19 16:00",
      "main": {
        "temperature": 284.45,
        "temperature_minimal": 284.45,
        "temperature_maximal": 284.45,
        "humidite": 74
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "scattered clouds",
          "icon": "03d"
        }
      ]
    },
    {
      "dateTime": "31/10/19 19:00",
      "main": {
        "temperature": 283.16,
        "temperature_minimal": 283.16,
        "temperature_maximal": 283.16,
        "humidite": 83
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "broken clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "31/10/19 22:00",
      "main": {
        "temperature": 282.29,
        "temperature_minimal": 282.29,
        "temperature_maximal": 282.29,
        "humidite": 89
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "01/11/19 01:00",
      "main": {
        "temperature": 282.62,
        "temperature_minimal": 282.62,
        "temperature_maximal": 282.62,
        "humidite": 91
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "01/11/19 04:00",
      "main": {
        "temperature": 283.16,
        "temperature_minimal": 283.16,
        "temperature_maximal": 283.16,
        "humidite": 90
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "01/11/19 07:00",
      "main": {
        "temperature": 283.63,
        "temperature_minimal": 283.63,
        "temperature_maximal": 283.63,
        "humidite": 95
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "01/11/19 10:00",
      "main": {
        "temperature": 284.53,
        "temperature_minimal": 284.53,
        "temperature_maximal": 284.53,
        "humidite": 93
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10d"
        }
      ]
    },
    {
      "dateTime": "01/11/19 13:00",
      "main": {
        "temperature": 285.59,
        "temperature_minimal": 285.59,
        "temperature_maximal": 285.59,
        "humidite": 92
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "moderate rain",
          "icon": "10d"
        }
      ]
    },
    {
      "dateTime": "01/11/19 16:00",
      "main": {
        "temperature": 287.57,
        "temperature_minimal": 287.57,
        "temperature_maximal": 287.57,
        "humidite": 95
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04d"
        }
      ]
    },
    {
      "dateTime": "01/11/19 19:00",
      "main": {
        "temperature": 288.15,
        "temperature_minimal": 288.15,
        "temperature_maximal": 288.15,
        "humidite": 93
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "01/11/19 22:00",
      "main": {
        "temperature": 288.15,
        "temperature_minimal": 288.15,
        "temperature_maximal": 288.15,
        "humidite": 89
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "02/11/19 01:00",
      "main": {
        "temperature": 287.65,
        "temperature_minimal": 287.65,
        "temperature_maximal": 287.65,
        "humidite": 86
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "02/11/19 04:00",
      "main": {
        "temperature": 287.41,
        "temperature_minimal": 287.41,
        "temperature_maximal": 287.41,
        "humidite": 79
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "02/11/19 07:00",
      "main": {
        "temperature": 286.96,
        "temperature_minimal": 286.96,
        "temperature_maximal": 286.96,
        "humidite": 83
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "02/11/19 10:00",
      "main": {
        "temperature": 286.88,
        "temperature_minimal": 286.88,
        "temperature_maximal": 286.88,
        "humidite": 80
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10d"
        }
      ]
    },
    {
      "dateTime": "02/11/19 13:00",
      "main": {
        "temperature": 288.0,
        "temperature_minimal": 288.0,
        "temperature_maximal": 288.0,
        "humidite": 70
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10d"
        }
      ]
    },
    {
      "dateTime": "02/11/19 16:00",
      "main": {
        "temperature": 287.17,
        "temperature_minimal": 287.17,
        "temperature_maximal": 287.17,
        "humidite": 72
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10d"
        }
      ]
    },
    {
      "dateTime": "02/11/19 19:00",
      "main": {
        "temperature": 286.14,
        "temperature_minimal": 286.14,
        "temperature_maximal": 286.14,
        "humidite": 79
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "02/11/19 22:00",
      "main": {
        "temperature": 285.81,
        "temperature_minimal": 285.81,
        "temperature_maximal": 285.81,
        "humidite": 82
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "03/11/19 01:00",
      "main": {
        "temperature": 285.79,
        "temperature_minimal": 285.79,
        "temperature_maximal": 285.79,
        "humidite": 82
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "03/11/19 04:00",
      "main": {
        "temperature": 285.47,
        "temperature_minimal": 285.47,
        "temperature_maximal": 285.47,
        "humidite": 80
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "03/11/19 07:00",
      "main": {
        "temperature": 282.75,
        "temperature_minimal": 282.75,
        "temperature_maximal": 282.75,
        "humidite": 69
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "03/11/19 10:00",
      "main": {
        "temperature": 283.26,
        "temperature_minimal": 283.26,
        "temperature_maximal": 283.26,
        "humidite": 76
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10d"
        }
      ]
    },
    {
      "dateTime": "03/11/19 13:00",
      "main": {
        "temperature": 284.95,
        "temperature_minimal": 284.95,
        "temperature_maximal": 284.95,
        "humidite": 62
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10d"
        }
      ]
    },
    {
      "dateTime": "03/11/19 16:00",
      "main": {
        "temperature": 285.42,
        "temperature_minimal": 285.42,
        "temperature_maximal": 285.42,
        "humidite": 64
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10d"
        }
      ]
    },
    {
      "dateTime": "03/11/19 19:00",
      "main": {
        "temperature": 283.14,
        "temperature_minimal": 283.14,
        "temperature_maximal": 283.14,
        "humidite": 69
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "03/11/19 22:00",
      "main": {
        "temperature": 282.13,
        "temperature_minimal": 282.13,
        "temperature_maximal": 282.13,
        "humidite": 72
      },
      "weather": [
        {
          "meteo": "Clouds",
          "detailMeteo": "overcast clouds",
          "icon": "04n"
        }
      ]
    },
    {
      "dateTime": "04/11/19 01:00",
      "main": {
        "temperature": 281.91,
        "temperature_minimal": 281.91,
        "temperature_maximal": 281.91,
        "humidite": 87
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "04/11/19 04:00",
      "main": {
        "temperature": 283.96,
        "temperature_minimal": 283.96,
        "temperature_maximal": 283.96,
        "humidite": 76
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "moderate rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "04/11/19 07:00",
      "main": {
        "temperature": 284.51,
        "temperature_minimal": 284.51,
        "temperature_maximal": 284.51,
        "humidite": 74
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "moderate rain",
          "icon": "10n"
        }
      ]
    },
    {
      "dateTime": "04/11/19 10:00",
      "main": {
        "temperature": 284.99,
        "temperature_minimal": 284.99,
        "temperature_maximal": 284.99,
        "humidite": 68
      },
      "weather": [
        {
          "meteo": "Rain",
          "detailMeteo": "light rain",
          "icon": "10d"
        }
      ]
    }
  ],
  "city": {
    "name": "Lens"
  }
}
````
