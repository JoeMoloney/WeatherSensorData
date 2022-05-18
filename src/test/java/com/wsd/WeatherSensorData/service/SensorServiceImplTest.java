/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.service;

import com.wsd.WeatherSensorData.entity.Sensor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Joe Moloney
 */
@ExtendWith(MockitoExtension.class)
public class SensorServiceImplTest
{
    @Mock
    Sensor sensor;
    
    @InjectMocks
    SensorServiceImpl sensorService;
    
//    @Test
//    public void returnTempWhenCountryProvided()
//    {
//        Sensor s = new Sensor();
//        s.setCountry("Netherlands");
//        s.setCity("Utrecht");
//        s.setTemperature(0);
//        s.setHumidity(0);
//        
//        String countryName = "Netherlands";
//        float expectedValue = 0;
//        
//        Mockito.when(sensorService.getCountryAverageTemp(countryName)).thenReturn(expectedValue);
//        Assert.assertEquals(expectedValue, s.getTemperature());
//    }
}
