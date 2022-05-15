/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Joe Moloney
 */
@Controller
@RequestMapping(path = "/WSD")
public class SpringController
{
    @Autowired
    private SensorRepository sensorRepository;
    
    @PostMapping(path = "/register") //Map only POST requests
    public @ResponseBody String registerSensor(@RequestParam int id, @RequestParam String countryName, @RequestParam String cityName)
    {
        Sensor s = new Sensor();
        s.setCountry(countryName);
        s.setCity(cityName);
        sensorRepository.save(s);
        return String.format("Saved: Sensor %d, Country: %s, City: %s", s.getId(), s.getCountry(), s.getCity());
    }
    
    @GetMapping(path = "/allSensors") //Map only GET requests
    public @ResponseBody Iterable<Sensor> getAllSensors()
    {
        return sensorRepository.findAll();
    }
}