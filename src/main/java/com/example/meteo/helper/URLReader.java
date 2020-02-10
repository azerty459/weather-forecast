package com.example.meteo.helper;

import java.net.*;
import java.io.*;

public class URLReader {
    public static String getContent(String urlAsString) throws Exception {
        String res = "";

        URL url = new URL(urlAsString);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            res += inputLine;
        in.close();
        return res;
    }
}
