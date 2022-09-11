package com.sensor.weatherservice.service;

import com.sensor.weatherservice.dto.SensorDTO;
import com.sensor.weatherservice.model.Sensor;
import com.sensor.weatherservice.repository.SensorRepository;
import com.sensor.weatherservice.utils.DateUtils;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;


@Service
public class SensorServiceImpl implements SensorService{
private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    private CriteriaBuilder criteriaBuilder;


    @Override
    public ResponseEntity<Object> createEvent(SensorDTO sensorDTO) {
//        if (sensorRepository.findOne(sensorDTO.getId()) != null) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
        Sensor sensor = new Sensor(sensorDTO.getId(), sensorDTO.getSensorName(), sensorDTO.getTemp(),
                sensorDTO.getWs(),sensorDTO.getHum(), sensorDTO.getCreatedAt());
        sensorRepository.save(sensor);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public  ResponseEntity<List<Sensor>> findBySensorName(String name){
        List<Sensor> sensorList = new ArrayList<>();
        sensorRepository.findBySensorName(name).forEach(s->sensorList.add(s));
        return sensorList.isEmpty() ?
                ResponseEntity.ok(new ArrayList<>()):
                ResponseEntity.ok(sensorList.stream()
                        .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Object> findTempStatsBySensor(String sensorName) {
        return ResponseEntity.ok(sensorRepository.findTempStatsBySensor(sensorName));
    }

//    @Override
//    public ResponseEntity<List<SensorDTO>> findAllBySensorNames(List<String> sensorNames) {
//        List<Sensor> sensorList = new ArrayList<>();
//        sensorRepository.findAllBySensorNames(sensorNames).forEach((s->sensorList.add(s)));
//        return sensorList.isEmpty() ?
//                ResponseEntity.ok(new ArrayList<>()):
//                ResponseEntity.ok(sensorList.stream().map(sensor->SensorDTO._toConvertFromSensorEntity(sensor))
//                        .collect(Collectors.toList()));
//    }

    @Override
    public ResponseEntity<List<Sensor>> findAll() {
        List<Sensor> sensorList = new ArrayList<>();
        sensorRepository.findAll().forEach((s->sensorList.add(s)));
        return sensorList.isEmpty() ?
                ResponseEntity.ok(new ArrayList<>()):
                ResponseEntity.ok(sensorList.stream().collect(Collectors.toList()));
    }

//    @Override
//    public ResponseEntity<List<SensorDTO>> findByStartDateBetween(String start, String end) {
//        List<Sensor> sensorList = new ArrayList<>();
//        sensorRepository.findByStartDateBetween(start,end).forEach((s->sensorList.add(s)));
//        return sensorList.isEmpty() ?
//                ResponseEntity.ok(new ArrayList<>()):
//                ResponseEntity.ok(sensorList.stream().map(sensor->SensorDTO._toConvertFromSensorEntity(sensor))
//                        .collect(Collectors.toList()));
//    }



}