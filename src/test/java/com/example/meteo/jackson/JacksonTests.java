package com.example.meteo.jackson;

import com.example.meteo.model.MeteoPrevision;
import com.example.meteo.model.apiobjects.ApiResponse;
import com.example.meteo.service.MeteoServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.List;

public class JacksonTests {
    String resultSample = "{\n" +
            "    \"cod\": \"200\",\n" +
            "    \"message\": 0,\n" +
            "    \"cnt\": 40,\n" +
            "    \"list\": [\n" +
            "        {\n" +
            "            \"dt\": 1582621200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 7.15,\n" +
            "                \"feels_like\": 0.24,\n" +
            "                \"temp_min\": 7.15,\n" +
            "                \"temp_max\": 8.12,\n" +
            "                \"pressure\": 1004,\n" +
            "                \"sea_level\": 1004,\n" +
            "                \"grnd_level\": 999,\n" +
            "                \"humidity\": 61,\n" +
            "                \"temp_kf\": -0.97\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 69\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.06,\n" +
            "                \"deg\": 267\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.13\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-25 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582632000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 7.59,\n" +
            "                \"feels_like\": 0.33,\n" +
            "                \"temp_min\": 7.59,\n" +
            "                \"temp_max\": 8.32,\n" +
            "                \"pressure\": 1003,\n" +
            "                \"sea_level\": 1003,\n" +
            "                \"grnd_level\": 999,\n" +
            "                \"humidity\": 65,\n" +
            "                \"temp_kf\": -0.73\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 67\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.85,\n" +
            "                \"deg\": 252\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.44\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-25 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582642800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 8.17,\n" +
            "                \"feels_like\": 0.47,\n" +
            "                \"temp_min\": 8.17,\n" +
            "                \"temp_max\": 8.65,\n" +
            "                \"pressure\": 1001,\n" +
            "                \"sea_level\": 1001,\n" +
            "                \"grnd_level\": 996,\n" +
            "                \"humidity\": 53,\n" +
            "                \"temp_kf\": -0.48\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 97\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.99,\n" +
            "                \"deg\": 264\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.44\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-25 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582653600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 6.28,\n" +
            "                \"feels_like\": -0.15,\n" +
            "                \"temp_min\": 6.28,\n" +
            "                \"temp_max\": 6.52,\n" +
            "                \"pressure\": 999,\n" +
            "                \"sea_level\": 999,\n" +
            "                \"grnd_level\": 994,\n" +
            "                \"humidity\": 70,\n" +
            "                \"temp_kf\": -0.24\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 98\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 6.62,\n" +
            "                \"deg\": 251\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.62\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-25 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582664400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 4.96,\n" +
            "                \"feels_like\": -4.12,\n" +
            "                \"temp_min\": 4.96,\n" +
            "                \"temp_max\": 4.96,\n" +
            "                \"pressure\": 997,\n" +
            "                \"sea_level\": 997,\n" +
            "                \"grnd_level\": 993,\n" +
            "                \"humidity\": 61,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 600,\n" +
            "                    \"main\": \"Snow\",\n" +
            "                    \"description\": \"légères chutes de neige\",\n" +
            "                    \"icon\": \"13n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 93\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 9.75,\n" +
            "                \"deg\": 268\n" +
            "            },\n" +
            "            \"snow\": {\n" +
            "                \"3h\": 1.44\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-25 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582675200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3.67,\n" +
            "                \"feels_like\": -4.51,\n" +
            "                \"temp_min\": 3.67,\n" +
            "                \"temp_max\": 3.67,\n" +
            "                \"pressure\": 997,\n" +
            "                \"sea_level\": 997,\n" +
            "                \"grnd_level\": 993,\n" +
            "                \"humidity\": 64,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"nuageux\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 60\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 8.37,\n" +
            "                \"deg\": 270\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-26 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582686000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 2.64,\n" +
            "                \"feels_like\": -4.79,\n" +
            "                \"temp_min\": 2.64,\n" +
            "                \"temp_max\": 2.64,\n" +
            "                \"pressure\": 997,\n" +
            "                \"sea_level\": 997,\n" +
            "                \"grnd_level\": 993,\n" +
            "                \"humidity\": 66,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"partiellement nuageux\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 31\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.19,\n" +
            "                \"deg\": 275\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-26 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582696800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 1.94,\n" +
            "                \"feels_like\": -5.06,\n" +
            "                \"temp_min\": 1.94,\n" +
            "                \"temp_max\": 1.94,\n" +
            "                \"pressure\": 998,\n" +
            "                \"sea_level\": 998,\n" +
            "                \"grnd_level\": 994,\n" +
            "                \"humidity\": 73,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"partiellement nuageux\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 29\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 6.7,\n" +
            "                \"deg\": 282\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-26 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582707600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3.57,\n" +
            "                \"feels_like\": -4.14,\n" +
            "                \"temp_min\": 3.57,\n" +
            "                \"temp_max\": 3.57,\n" +
            "                \"pressure\": 1001,\n" +
            "                \"sea_level\": 1001,\n" +
            "                \"grnd_level\": 997,\n" +
            "                \"humidity\": 68,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"couvert\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 99\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.82,\n" +
            "                \"deg\": 288\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-26 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582718400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 6.16,\n" +
            "                \"feels_like\": -0.94,\n" +
            "                \"temp_min\": 6.16,\n" +
            "                \"temp_max\": 6.16,\n" +
            "                \"pressure\": 1004,\n" +
            "                \"sea_level\": 1004,\n" +
            "                \"grnd_level\": 999,\n" +
            "                \"humidity\": 58,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"nuageux\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 81\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.01,\n" +
            "                \"deg\": 299\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-26 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582729200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 7.32,\n" +
            "                \"feels_like\": 0.08,\n" +
            "                \"temp_min\": 7.32,\n" +
            "                \"temp_max\": 7.32,\n" +
            "                \"pressure\": 1006,\n" +
            "                \"sea_level\": 1006,\n" +
            "                \"grnd_level\": 1001,\n" +
            "                \"humidity\": 55,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 75\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.28,\n" +
            "                \"deg\": 291\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.19\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-26 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582740000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 4.84,\n" +
            "                \"feels_like\": -1.4,\n" +
            "                \"temp_min\": 4.84,\n" +
            "                \"temp_max\": 4.84,\n" +
            "                \"pressure\": 1008,\n" +
            "                \"sea_level\": 1008,\n" +
            "                \"grnd_level\": 1003,\n" +
            "                \"humidity\": 70,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 72\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 6.05,\n" +
            "                \"deg\": 291\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.69\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-26 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582750800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3.61,\n" +
            "                \"feels_like\": -2.24,\n" +
            "                \"temp_min\": 3.61,\n" +
            "                \"temp_max\": 3.61,\n" +
            "                \"pressure\": 1009,\n" +
            "                \"sea_level\": 1009,\n" +
            "                \"grnd_level\": 1005,\n" +
            "                \"humidity\": 63,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 600,\n" +
            "                    \"main\": \"Snow\",\n" +
            "                    \"description\": \"légères chutes de neige\",\n" +
            "                    \"icon\": \"13n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 36\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 4.99,\n" +
            "                \"deg\": 279\n" +
            "            },\n" +
            "            \"snow\": {\n" +
            "                \"3h\": 0.13\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-26 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582761600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3,\n" +
            "                \"feels_like\": -1.48,\n" +
            "                \"temp_min\": 3,\n" +
            "                \"temp_max\": 3,\n" +
            "                \"pressure\": 1009,\n" +
            "                \"sea_level\": 1009,\n" +
            "                \"grnd_level\": 1004,\n" +
            "                \"humidity\": 65,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"nuageux\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 57\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3,\n" +
            "                \"deg\": 234\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-27 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582772400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 2.79,\n" +
            "                \"feels_like\": -2.71,\n" +
            "                \"temp_min\": 2.79,\n" +
            "                \"temp_max\": 2.79,\n" +
            "                \"pressure\": 1006,\n" +
            "                \"sea_level\": 1006,\n" +
            "                \"grnd_level\": 1002,\n" +
            "                \"humidity\": 90,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.31,\n" +
            "                \"deg\": 212\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.13\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-27 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582783200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3.33,\n" +
            "                \"feels_like\": -3.09,\n" +
            "                \"temp_min\": 3.33,\n" +
            "                \"temp_max\": 3.33,\n" +
            "                \"pressure\": 1002,\n" +
            "                \"sea_level\": 1002,\n" +
            "                \"grnd_level\": 997,\n" +
            "                \"humidity\": 85,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 6.56,\n" +
            "                \"deg\": 199\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 1.06\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-27 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582794000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 1.7,\n" +
            "                \"feels_like\": -3.81,\n" +
            "                \"temp_min\": 1.7,\n" +
            "                \"temp_max\": 1.7,\n" +
            "                \"pressure\": 996,\n" +
            "                \"sea_level\": 996,\n" +
            "                \"grnd_level\": 992,\n" +
            "                \"humidity\": 95,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 601,\n" +
            "                    \"main\": \"Snow\",\n" +
            "                    \"description\": \"chutes de neige\",\n" +
            "                    \"icon\": \"13d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.25,\n" +
            "                \"deg\": 149\n" +
            "            },\n" +
            "            \"snow\": {\n" +
            "                \"3h\": 3.5\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-27 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582804800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 1.97,\n" +
            "                \"feels_like\": -1.47,\n" +
            "                \"temp_min\": 1.97,\n" +
            "                \"temp_max\": 1.97,\n" +
            "                \"pressure\": 994,\n" +
            "                \"sea_level\": 994,\n" +
            "                \"grnd_level\": 990,\n" +
            "                \"humidity\": 94,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 601,\n" +
            "                    \"main\": \"Snow\",\n" +
            "                    \"description\": \"chutes de neige\",\n" +
            "                    \"icon\": \"13d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.32,\n" +
            "                \"deg\": 50\n" +
            "            },\n" +
            "            \"snow\": {\n" +
            "                \"3h\": 3.44\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-27 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582815600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3.6,\n" +
            "                \"feels_like\": -3.38,\n" +
            "                \"temp_min\": 3.6,\n" +
            "                \"temp_max\": 3.6,\n" +
            "                \"pressure\": 999,\n" +
            "                \"sea_level\": 999,\n" +
            "                \"grnd_level\": 994,\n" +
            "                \"humidity\": 91,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.64,\n" +
            "                \"deg\": 320\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.13\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-27 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582826400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3.23,\n" +
            "                \"feels_like\": -2.58,\n" +
            "                \"temp_min\": 3.23,\n" +
            "                \"temp_max\": 3.23,\n" +
            "                \"pressure\": 1004,\n" +
            "                \"sea_level\": 1004,\n" +
            "                \"grnd_level\": 999,\n" +
            "                \"humidity\": 80,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 86\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.49,\n" +
            "                \"deg\": 299\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.19\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-27 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582837200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 2.95,\n" +
            "                \"feels_like\": -3.23,\n" +
            "                \"temp_min\": 2.95,\n" +
            "                \"temp_max\": 2.95,\n" +
            "                \"pressure\": 1008,\n" +
            "                \"sea_level\": 1008,\n" +
            "                \"grnd_level\": 1004,\n" +
            "                \"humidity\": 72,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"partiellement nuageux\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 26\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.67,\n" +
            "                \"deg\": 286\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-27 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582848000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 2.46,\n" +
            "                \"feels_like\": -3.37,\n" +
            "                \"temp_min\": 2.46,\n" +
            "                \"temp_max\": 2.46,\n" +
            "                \"pressure\": 1012,\n" +
            "                \"sea_level\": 1012,\n" +
            "                \"grnd_level\": 1007,\n" +
            "                \"humidity\": 74,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 801,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"peu nuageux\",\n" +
            "                    \"icon\": \"02n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 13\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.16,\n" +
            "                \"deg\": 278\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-28 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582858800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 1.5,\n" +
            "                \"feels_like\": -3.44,\n" +
            "                \"temp_min\": 1.5,\n" +
            "                \"temp_max\": 1.5,\n" +
            "                \"pressure\": 1014,\n" +
            "                \"sea_level\": 1014,\n" +
            "                \"grnd_level\": 1009,\n" +
            "                \"humidity\": 79,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"ciel dégagé\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.87,\n" +
            "                \"deg\": 260\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-28 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582869600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 1.37,\n" +
            "                \"feels_like\": -2.87,\n" +
            "                \"temp_min\": 1.37,\n" +
            "                \"temp_max\": 1.37,\n" +
            "                \"pressure\": 1015,\n" +
            "                \"sea_level\": 1015,\n" +
            "                \"grnd_level\": 1010,\n" +
            "                \"humidity\": 80,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"partiellement nuageux\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 28\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.88,\n" +
            "                \"deg\": 244\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-28 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582880400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3.41,\n" +
            "                \"feels_like\": -1.23,\n" +
            "                \"temp_min\": 3.41,\n" +
            "                \"temp_max\": 3.41,\n" +
            "                \"pressure\": 1015,\n" +
            "                \"sea_level\": 1015,\n" +
            "                \"grnd_level\": 1011,\n" +
            "                \"humidity\": 75,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"couvert\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.67,\n" +
            "                \"deg\": 206\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-28 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582891200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 5.75,\n" +
            "                \"feels_like\": 0.68,\n" +
            "                \"temp_min\": 5.75,\n" +
            "                \"temp_max\": 5.75,\n" +
            "                \"pressure\": 1014,\n" +
            "                \"sea_level\": 1014,\n" +
            "                \"grnd_level\": 1010,\n" +
            "                \"humidity\": 66,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"couvert\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 4.38,\n" +
            "                \"deg\": 196\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-28 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582902000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 4.33,\n" +
            "                \"feels_like\": -1.3,\n" +
            "                \"temp_min\": 4.33,\n" +
            "                \"temp_max\": 4.33,\n" +
            "                \"pressure\": 1011,\n" +
            "                \"sea_level\": 1011,\n" +
            "                \"grnd_level\": 1007,\n" +
            "                \"humidity\": 77,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.34,\n" +
            "                \"deg\": 177\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.19\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-28 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582912800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3.85,\n" +
            "                \"feels_like\": -2.81,\n" +
            "                \"temp_min\": 3.85,\n" +
            "                \"temp_max\": 3.85,\n" +
            "                \"pressure\": 1008,\n" +
            "                \"sea_level\": 1008,\n" +
            "                \"grnd_level\": 1003,\n" +
            "                \"humidity\": 91,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.25,\n" +
            "                \"deg\": 161\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.37\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-28 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582923600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 5.09,\n" +
            "                \"feels_like\": -0.39,\n" +
            "                \"temp_min\": 5.09,\n" +
            "                \"temp_max\": 5.09,\n" +
            "                \"pressure\": 1004,\n" +
            "                \"sea_level\": 1004,\n" +
            "                \"grnd_level\": 1000,\n" +
            "                \"humidity\": 91,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.88,\n" +
            "                \"deg\": 179\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.69\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-28 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582934400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 7.76,\n" +
            "                \"feels_like\": 3.23,\n" +
            "                \"temp_min\": 7.76,\n" +
            "                \"temp_max\": 7.76,\n" +
            "                \"pressure\": 1000,\n" +
            "                \"sea_level\": 1000,\n" +
            "                \"grnd_level\": 996,\n" +
            "                \"humidity\": 96,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.53,\n" +
            "                \"deg\": 190\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 2.56\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-29 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582945200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 10.1,\n" +
            "                \"feels_like\": 4.3,\n" +
            "                \"temp_min\": 10.1,\n" +
            "                \"temp_max\": 10.1,\n" +
            "                \"pressure\": 996,\n" +
            "                \"sea_level\": 996,\n" +
            "                \"grnd_level\": 991,\n" +
            "                \"humidity\": 91,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 501,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"pluie modérée\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.87,\n" +
            "                \"deg\": 199\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 3.63\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-29 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582956000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 9.92,\n" +
            "                \"feels_like\": 2.63,\n" +
            "                \"temp_min\": 9.92,\n" +
            "                \"temp_max\": 9.92,\n" +
            "                \"pressure\": 991,\n" +
            "                \"sea_level\": 991,\n" +
            "                \"grnd_level\": 987,\n" +
            "                \"humidity\": 78,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 9.18,\n" +
            "                \"deg\": 200\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.19\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-29 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582966800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 9.37,\n" +
            "                \"feels_like\": 1.85,\n" +
            "                \"temp_min\": 9.37,\n" +
            "                \"temp_max\": 9.37,\n" +
            "                \"pressure\": 990,\n" +
            "                \"sea_level\": 990,\n" +
            "                \"grnd_level\": 986,\n" +
            "                \"humidity\": 71,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 8.96,\n" +
            "                \"deg\": 239\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 2.75\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-29 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582977600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 7.64,\n" +
            "                \"feels_like\": -1.62,\n" +
            "                \"temp_min\": 7.64,\n" +
            "                \"temp_max\": 7.64,\n" +
            "                \"pressure\": 994,\n" +
            "                \"sea_level\": 994,\n" +
            "                \"grnd_level\": 989,\n" +
            "                \"humidity\": 64,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 99\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 10.67,\n" +
            "                \"deg\": 257\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 1.31\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-29 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582988400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 7.27,\n" +
            "                \"feels_like\": -2.27,\n" +
            "                \"temp_min\": 7.27,\n" +
            "                \"temp_max\": 7.27,\n" +
            "                \"pressure\": 996,\n" +
            "                \"sea_level\": 996,\n" +
            "                \"grnd_level\": 991,\n" +
            "                \"humidity\": 56,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 94\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 10.6,\n" +
            "                \"deg\": 252\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.44\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-29 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1582999200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 5.41,\n" +
            "                \"feels_like\": -2.81,\n" +
            "                \"temp_min\": 5.41,\n" +
            "                \"temp_max\": 5.41,\n" +
            "                \"pressure\": 997,\n" +
            "                \"sea_level\": 997,\n" +
            "                \"grnd_level\": 993,\n" +
            "                \"humidity\": 62,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 97\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 8.65,\n" +
            "                \"deg\": 243\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.5\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-29 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1583010000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 4.78,\n" +
            "                \"feels_like\": -3.02,\n" +
            "                \"temp_min\": 4.78,\n" +
            "                \"temp_max\": 4.78,\n" +
            "                \"pressure\": 999,\n" +
            "                \"sea_level\": 999,\n" +
            "                \"grnd_level\": 995,\n" +
            "                \"humidity\": 66,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 8.1,\n" +
            "                \"deg\": 239\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.81\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-02-29 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1583020800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 4.34,\n" +
            "                \"feels_like\": -2.02,\n" +
            "                \"temp_min\": 4.34,\n" +
            "                \"temp_max\": 4.34,\n" +
            "                \"pressure\": 1001,\n" +
            "                \"sea_level\": 1001,\n" +
            "                \"grnd_level\": 996,\n" +
            "                \"humidity\": 68,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 6.04,\n" +
            "                \"deg\": 238\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.88\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-03-01 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1583031600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 3.11,\n" +
            "                \"feels_like\": -3.76,\n" +
            "                \"temp_min\": 3.11,\n" +
            "                \"temp_max\": 3.11,\n" +
            "                \"pressure\": 1001,\n" +
            "                \"sea_level\": 1001,\n" +
            "                \"grnd_level\": 997,\n" +
            "                \"humidity\": 91,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.38,\n" +
            "                \"deg\": 231\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0.38\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-03-01 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1583042400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 4.11,\n" +
            "                \"feels_like\": -2.56,\n" +
            "                \"temp_min\": 4.11,\n" +
            "                \"temp_max\": 4.11,\n" +
            "                \"pressure\": 1002,\n" +
            "                \"sea_level\": 1002,\n" +
            "                \"grnd_level\": 997,\n" +
            "                \"humidity\": 84,\n" +
            "                \"temp_kf\": 0\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"légère pluie\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 7.05,\n" +
            "                \"deg\": 227\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 1.13\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2020-03-01 06:00:00\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"city\": {\n" +
            "        \"id\": 2998324,\n" +
            "        \"name\": \"Lille\",\n" +
            "        \"coord\": {\n" +
            "            \"lat\": 50.633,\n" +
            "            \"lon\": 3.0586\n" +
            "        },\n" +
            "        \"country\": \"FR\",\n" +
            "        \"population\": 228328,\n" +
            "        \"timezone\": 3600,\n" +
            "        \"sunrise\": 1582612903,\n" +
            "        \"sunset\": 1582651230\n" +
            "    }\n" +
            "}";

    @Test
    public void TestJackson() throws Exception{
        System.out.println(resultSample);
        ObjectMapper mapper = new ObjectMapper();
        ApiResponse apiResponse = mapper.readValue(resultSample, ApiResponse.class);
        System.out.println(apiResponse.apiMeteoPrevisions.get(0).apiWeathers.get(0).description);
    }
}
