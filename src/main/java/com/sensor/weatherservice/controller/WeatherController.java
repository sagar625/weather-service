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

//    @PostMapping(path="event", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Sensor> add_event(@RequestBody Sensor sensor){
//        return new ResponseEntity<>(sensor, HttpStatus.CREATED);
//    }

    @PostMapping(value = "/events")
    public ResponseEntity addEvent(@RequestBody SensorDTO body) {
        return sensorService.createEvent(body);
    }

@GetMapping(value = "/{sensorName}", produces = "application/json")
    ResponseEntity<List<Sensor>> getDataBySensorName(@PathVariable String sensorName) {
        return sensorService.findBySensorName(sensorName);
}

    @GetMapping(value = "/all_stats/{sensorName}", produces = "application/json")
    ResponseEntity<Object> getAvgDataBySensorName(@PathVariable String sensorName) {
        return sensorService.findTempStatsBySensor(sensorName);
    }


    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<List<Sensor>> getAllSensorData() {
        return sensorService.findAll();
    }


//    @GetMapping("/sensor_data/created_at")
//    public ResponseEntity<List<SensorDTO>> findByStartDateBetween (@RequestParam String startDate,
//                                                                 @RequestParam String endDate) {
//        return sensorService.findByStartDateBetween(startDate,endDate);
//    }

}
