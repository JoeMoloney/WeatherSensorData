/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.service;

import com.wsd.WeatherSensorData.entitys.Sensor;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author K00243015 | Joe Moloney
 */
public class SensorServiceImpl implements SensorService
{
    @Autowired
    CrudRepository repo;
    
    @Override
    public void save(Sensor s)
    {
        repo.save(s);
    }

    @Override
    public Iterable<Sensor> findAll()
    {
        return repo.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer i)
    {
        return repo.findById(i);
    }

    @Override
    public void delete(Sensor s)
    {
        repo.delete(s);
    }
    
}
