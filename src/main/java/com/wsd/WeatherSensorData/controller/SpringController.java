/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.controller;

import com.wsd.WeatherSensorData.entity.Sensor;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.wsd.WeatherSensorData.service.SensorService;

/**
 *
 * @author Joe Moloney
 */
@Controller
@RequestMapping(path = "/wsd") //Map requests to controller methods
public class SpringController
{
    @Autowired
    private SensorService sensorService;
    
    @PostMapping(path = "/register") //Register a new sensor using POST request
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String registerSensor(@RequestParam String countryName, 
            @RequestParam String cityName, @RequestParam int temperature, @RequestParam int humidity)
    {
        sensorService.save(new Sensor(countryName, cityName, temperature, humidity));
        return String.format("Saved: Country: %s, City: %s, Temperature: %d, Humidity: %d", 
                countryName, cityName, temperature, humidity);
    }
    
    @GetMapping(path = "/getAll") //Get all sensors and data
    public @ResponseBody Iterable<Sensor> getAllSensors()
    {
        return sensorService.findAll();
    }
    
    @GetMapping(path = "/getSensor/{id}") //Get specific sensors data using GET request
    public @ResponseBody Sensor getSensor(@PathVariable String id)
    {
        Optional<Sensor> opt = sensorService.findById(Integer.parseInt(id));
        
        if (opt.isPresent())
            return opt.get();
        else 
            throw new RuntimeException("Sensor not found for id: "+id);
    }
    
    @GetMapping(path = "/deleteSensor/{id}")
    public @ResponseBody String deleteSensor(@PathVariable String id)
    {
        sensorService.delete(getSensor(id));
        return String.format("Sensor %s deleted", id);
    }
    
    @GetMapping(path = "/getAverageTemp/{country}")
    public @ResponseBody Float getCountryAverageTemp(@PathVariable String country)
    {
        return sensorService.getCountryAverageTemp(country);
    }
}