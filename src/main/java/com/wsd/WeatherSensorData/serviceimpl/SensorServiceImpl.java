/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.serviceimpl;

import com.wsd.WeatherSensorData.entitys.Sensor;
import com.wsd.WeatherSensorData.repositorys.SensorRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.wsd.WeatherSensorData.services.SensorService;
import org.springframework.stereotype.Component;

/**
 *
 * @author Joe Moloney
 */
@Component
public class SensorServiceImpl implements SensorService
{
    @Autowired
    private SensorRepository sensorRepository;
    
    @Override
    public void save(Sensor s)
    {
        sensorRepository.save(s);
    }

    @Override
    public Iterable<Sensor> findAll()
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
    
}