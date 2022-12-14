package com.sensor.weatherservice.service;

import com.sensor.weatherservice.dto.SensorDTO;
import com.sensor.weatherservice.model.Sensor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SensorService {
    ResponseEntity<Object> createEvent(SensorDTO sensorDTO);
    ResponseEntity<List<Sensor>> findBySensorName(String sensorName);
    //    ResponseEntity<List<SensorDTO>> findAllBySensorNames(List<String> sensorNames)

    ResponseEntity<Object> findTempStatsBySensor(String sensorName);

    ResponseEntity<Object> findHumStatsBySensor(String sensorName);

    ResponseEntity<Object> findWSStatsBySensor(String sensorName);

    ResponseEntity<List<Sensor>> findAll();

//    ResponseEntity<List<Sensor>> findBySensors(String[] names);

//    ResponseEntity<List<Sensor>> findByStartDateBetween(
//            Date timeStart,
//            Date timeEnd);

}
