package com.wsd.WeatherSensorData;

import com.wsd.WeatherSensorData.entitys.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.wsd.WeatherSensorData.service.SensorService;

@SpringBootApplication
public class WeatherSensorDataApplication implements CommandLineRunner
{
    @Autowired
    SensorService sensorRepository;
    
    public static void main(String[] args) 
    {
	SpringApplication.run(WeatherSensorDataApplication.class, args);
    }

    //Insert test data on load
    @Override
    public void run(String... args) throws Exception
    {
        sensorRepository.save(new Sensor("Ireland", "Limerick", 20, 30));
        sensorRepository.save(new Sensor("Ireland", "Galway", 25, 35));
        sensorRepository.save(new Sensor("Ireland", "Athlone", 20, 20));
        sensorRepository.save(new Sensor("Ireland", "Cork", 15, 45));
    }
}