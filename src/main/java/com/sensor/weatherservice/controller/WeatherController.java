package com.sensor.weatherservice.controller;

import com.sensor.weatherservice.dto.SensorDTO;
import com.sensor.weatherservice.model.Sensor;
import com.sensor.weatherservice.repository.SensorRepository;
import com.sensor.weatherservice.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensorRepository sensorRepository;

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @PostMapping(value = "/events")
    public ResponseEntity addEvent(@RequestBody SensorDTO body) {
        return sensorService.createEvent(body);
    }

    @GetMapping(value = "/{sensorName}", produces = "application/json")
    ResponseEntity<List<Sensor>> getDataBySensorName(@PathVariable String sensorName) {
        return sensorService.findBySensorName(sensorName);
}

    @GetMapping(value = "/all_stats_temp/{sensorName}", produces = "application/json")
    ResponseEntity<Object> getAvgTempDataBySensorName(@PathVariable String sensorName) {
        return sensorService.findTempStatsBySensor(sensorName);
    }

    @GetMapping(value = "/all_stats_hum/{sensorName}", produces = "application/json")
    ResponseEntity<Object> getAvgHumDataBySensorName(@PathVariable String sensorName) {
        return sensorService.findTempStatsBySensor(sensorName);
    }

    @GetMapping(value = "/all_stats_ws/{sensorName}", produces = "application/json")
    ResponseEntity<Object> getAvgWSDataBySensorName(@PathVariable String sensorName) {
        return sensorService.findWSStatsBySensor(sensorName);
    }

    @GetMapping(value = "/all_sensors", produces = "application/json")
    ResponseEntity<List<Sensor>> getAllSensorData() {
        return sensorService.findAll();
    }

//    @GetMapping(value = "/sensors", produces = "application/json")
//    ResponseEntity<List<Sensor>> getSensorsData(@RequestParam String[]  names) {
//        return sensorService.findBySensors(names);
//    }

}
