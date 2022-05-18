/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.repository;

import com.wsd.WeatherSensorData.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Joe Moloney
 */

public interface SensorRepository extends JpaRepository<Sensor, Integer>
{}
