/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Joe Moloney
 */
@Controller
@RequestMapping(path = "/wsd")
public class SpringController
{
    @Autowired
    private SensorRepository sensorRepository;
    
    @PostMapping(path = "/register") //Register a new sensor
    public @ResponseBody String registerSensor(@RequestParam String countryName, 
            @RequestParam String cityName, @RequestParam float temperature, @RequestParam float humidity, @RequestParam float pressure)
    {   
        sensorRepository.save(new Sensor(countryName, cityName, temperature, humidity, pressure));
        return String.format("Saved: Country: %s, City: %s, Temperature: %d, Humidity: %d, Pressure: %d", 
                countryName, cityName, temperature, humidity, pressure);
    }
    
    @GetMapping(path = "/getAll") //Get all sensors and data
    public @ResponseBody Iterable<Sensor> getAllSensors()
    {
        return sensorRepository.findAll();
    }
    
    @GetMapping(path = "/getSensor/{id}") //Get specific sensors data
    public @ResponseBody Sensor getSensor(@PathVariable String id)
    {
        Optional<Sensor> opt = sensorRepository.findById(Integer.parseInt(id));
        
        if (opt.isPresent())
            return opt.get();
        else 
            throw new RuntimeException("Sensor not found for id: "+id);
    }
    
    @GetMapping(path = "/updateSensor/{id}")
    @Transactional
    public @ResponseBody Sensor updateSensor(@PathVariable String id)
    {
        return null;
    }
    
    @GetMapping(path = "/deleteSensor/{id}")
    public @ResponseBody String deleteSensor(@PathVariable String id)
    {
        sensorRepository.delete(getSensor(id));
        return String.format("Sensor %s deleted", id);
    }
}