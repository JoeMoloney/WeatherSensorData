/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.repositorys;

import com.wsd.WeatherSensorData.entitys.Sensor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author K00243015 | Joe Moloney
 */

public interface SensorRepository extends CrudRepository<Sensor, Integer>
{}
