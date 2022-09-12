package com.sensor.weatherservice.repository;

import com.sensor.weatherservice.dto.SensorDTO;
import com.sensor.weatherservice.model.Sensor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.*;
import java.util.function.Function;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findBySensorName(String sensorName);

    List<Sensor> findAll();

    @Query("SELECT AVG(p.temp), MIN(p.temp), MAX(p.temp), SUM(p.temp) from Sensor p where p.sensorName = ?1")
    Object findTempStatsBySensor(String sensorName);

    @Query("SELECT AVG(p.hum), MIN(p.hum), MAX(p.hum), SUM(p.hum) from Sensor p where p.sensorName = ?1")
    Object findHumStatsBySensor(String sensorName);


    @Query("SELECT AVG(p.ws), MIN(p.ws), MAX(p.ws), SUM(p.ws) from Sensor p where p.sensorName = ?1")
    Object findWSStatsBySensor(String sensorName);
//    @Query("SELECT AVG(a.hum), MIN(p.temp), MAX(p.temp), SUM(p.temp) from Sensor a where a.created_at between ?1 and ?2")
//    List<Sensor> findByStartDateBetween(
//            Date timeStart,
//            Date timeEnd);

}
