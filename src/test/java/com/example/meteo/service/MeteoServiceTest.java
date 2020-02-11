package com.example.meteo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MeteoServiceTest {

    @Autowired
    MeteoService service;

    @Test
    public void TestMeteoService() throws Exception {
        //A AMELIORER --- Faire marcher Autowired dans les tests
        if (service == null) {
            service = new MeteoServiceImpl();
        }

        System.out.println(service.getPrevisionsForCity("Lille"));
        System.out.println(service.getHottestDayForCity("Lille"));
    }

    @Test
    public void testPourApprendre(){
        double a = - 0.3;
        System.out.println((int)Math.signum(a));
    }

}
