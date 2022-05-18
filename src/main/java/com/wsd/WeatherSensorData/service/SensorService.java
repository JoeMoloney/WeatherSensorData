/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.service;

import com.wsd.WeatherSensorData.entity.Sensor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Joe Moloney
 */
public interface SensorService
{
    void save(Sensor s);
    List<Sensor> findAll();
    Optional<Sensor> findById(Integer i);
    void delete(Sensor s);
    
    Float getCountryAverageTemp(String country);
    int getTemperature(Sensor s);
}
