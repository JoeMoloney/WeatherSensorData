/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.Repositorys;

import com.wsd.WeatherSensorData.Entitys.Sensor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Joe Moloney
 */
public interface SensorRepository extends CrudRepository<Sensor, Integer>
{
    
}
