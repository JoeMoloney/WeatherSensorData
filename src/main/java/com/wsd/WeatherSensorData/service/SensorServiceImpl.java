/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.service;

import com.wsd.WeatherSensorData.entity.Sensor;
import com.wsd.WeatherSensorData.repository.SensorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Joe Moloney
 */
@Component //Custom Bean
public class SensorServiceImpl implements SensorService
{
    @Autowired //Inject Bean into parent Bean
    private SensorRepository sensorRepository;
    
    @Override
    public void save(Sensor s)
    {
        sensorRepository.save(s);
    }

    @Override
    public List<Sensor> findAll()
    {
        return sensorRepository.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer i)
    {
        return sensorRepository.findById(i);
    }

    @Override
    public void delete(Sensor s)
    {
        sensorRepository.delete(s);
    }
    
    @Override
    public Float getCountryAverageTemp(String country)
    {
        int count = 0, tally = 0;
        float average;
        List<Sensor> countrySensors = findAll();
        
        for (Sensor s : countrySensors)
        {
            if(s.getCountry().equalsIgnoreCase(country))
            {
                tally += s.getTemperature();
                count++;
            }
        }
        
        return average = tally / count;
    }

    @Override
    public int getTemperature(Sensor s)
    {
        return s.getTemperature();
    }
}