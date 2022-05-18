/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wsd.WeatherSensorData.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import com.wsd.WeatherSensorData.entitys.Sensor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.annotation.DirtiesContext;

/**
 *
 * @author K00243015 | Joe Moloney
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //Look for main configuration 
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SpringControllerTest
{   
    @Autowired //Resolve & Inject collaborating beans into this bean
    private TestRestTemplate restTemplate;
    @Autowired
    private SpringController springController; //Main application controller
    
    @LocalServerPort
    private int port;
    
    @Bean
    @Primary
    public TestRestTemplate testRestTemplate()
    {
        return new TestRestTemplate(TestRestTemplate.HttpClientOption.ENABLE_REDIRECTS, TestRestTemplate.HttpClientOption.ENABLE_COOKIES);
    }
    
//    @Before
//    public void preLoadTestData()
//    {
//        sensorService.save(new Sensor("Ireland", "Limerick", 20, 30));
//        sensorService.save(new Sensor("Ireland", "Galway", 25, 35));
//        sensorService.save(new Sensor("Ireland", "Athlone", 20, 20));
//        sensorService.save(new Sensor("Ireland", "Cork", 15, 45));
//    }
    
    @Test
    public void contextLoads() throws Exception //Sanity Check
    {
        assertThat(springController).isNotNull();
    }
    
//    @Test
    public void testRegisterNewSensor()
    {
        Sensor s1 = new Sensor();
        s1.setCountry("Netherlands");
        s1.setCity("Utrecht");
        s1.setTemperature(35);
        s1.setHumidity(21);
        
        restTemplate.postForObject(url("/wsd/register"), s1, String.class);
        
        Sensor response = restTemplate.postForObject(url("/wsd/register"), s1, Sensor.class);
        
        assertEquals("Netherlands", response.getCountry());
    }
    
    private String url(String path)
    {
        return String.format("http://localhost:%d/%s", port, path);
    }
}
