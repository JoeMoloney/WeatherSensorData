/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.service;

import com.wsd.WeatherSensorData.entity.Sensor;
import com.wsd.WeatherSensorData.repository.SensorRepository;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Joe Moloney
 */
@ExtendWith(MockitoExtension.class)
public class SensorServiceImplTest
{   
    @Mock
    SensorRepository mockSensorRepository;
    
    @InjectMocks
    SensorServiceImpl mockSensorService;
    
    @Test
    public void returnTempWhenCountryProvided()
    {
        List<Sensor> sensorList = new ArrayList<>();
        
        Sensor s = new Sensor();
        s.setCountry("Netherlands");
        s.setCity("Utrecht");
        s.setTemperature(20);
        s.setHumidity(15);
        
        sensorList.add(s);
        
        int expectedValue = 20;
        String countryName = "Netherlands";
        
        Mockito.when(mockSensorRepository.findAll()).thenReturn(sensorList);
        assertEquals(expectedValue, mockSensorService.getCountryAverageTemp(countryName));
    }
}
