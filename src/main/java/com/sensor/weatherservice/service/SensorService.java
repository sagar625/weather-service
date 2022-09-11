package com.sensor.weatherservice.service;

import com.sensor.weatherservice.dto.SensorDTO;
import com.sensor.weatherservice.model.Sensor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface SensorService {
    ResponseEntity<Object> createEvent(SensorDTO sensorDTO);
    ResponseEntity<List<Sensor>> findBySensorName(String sensorName);
    //    ResponseEntity<List<SensorDTO>> findAllBySensorNames(List<String> sensorNames)

    ResponseEntity<Object> findTempStatsBySensor(String sensorName);

    ResponseEntity<List<Sensor>> findAll();


//    ResponseEntity<List<Sensor>> findByStartDateBetween(
//            Date timeStart,
//            Date timeEnd);

}
