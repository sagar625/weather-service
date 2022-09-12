package com.sensor.weatherservice.controller;

import com.sensor.weatherservice.dto.SensorDTO;
import com.sensor.weatherservice.model.Sensor;
import com.sensor.weatherservice.repository.SensorRepository;
import com.sensor.weatherservice.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<List<Sensor>> getAllSensorData() {
        return sensorService.findAll();
    }

}
