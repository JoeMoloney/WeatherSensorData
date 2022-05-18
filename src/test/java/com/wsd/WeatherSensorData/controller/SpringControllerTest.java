/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Joe Moloney
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //Look for main configuration 
class SpringControllerTest
{   
    @Autowired
    private SpringController springController; //Main application controller
    
    @Test
    public void contextLoads() throws Exception //Sanity Check
    {
        assertThat(springController).isNotNull();
    }
}
