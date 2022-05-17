/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Joe Moloney
 */
@Entity
public class Sensor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String country;
    private String city;
    private int temperature;
    private int humidity;
    private int pressure;
    
    public Sensor(){}
    public Sensor(String country, String city, 
            int temperature, int humidity, int pressure)
    {
        this.country = country;
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }
    
    public String getCountry()
    {
        return this.country;
    }
    public void setCountry(String country)
    {
        this.country = country;
    }
    
    public String getCity()
    {
        return this.city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public float getTemperature()
    {
        return this.temperature;
    }
    public void setTemperature(int temp)
    {
        this.temperature = temp;
    }
    
    public float getHumidity()
    {
        return this.humidity;
    }
    public void setHumidity(int hum)
    {
        this.humidity = hum;
    }
    
    public float getPressure()
    {
        return this.pressure;
    }
    public void setPressure(int press)
    {
        this.pressure = press;
    }
}
