package com.sensor.weatherservice.model;


import jdk.jfr.Enabled;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               Table(name= "SENSOR")
public class Sensor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String sensorName;
    private Float temp;
    private Float ws;

    private Float hum;
    @CreationTimestamp
    private Date createdAt;

    public Sensor() {
    }

    public Sensor(Long id, String sensorName, Float temp, Float ws, Float hum, Date createdAt ) {
        this.id = id;
        this.sensorName = sensorName;
        this.temp = temp;
        this.ws = ws;
        this.hum = hum;
        this.createdAt = createdAt;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public Float getWs() {
        return ws;
    }

    public void setWs(Float ws) {
        this.ws = ws;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getHum() {
        return hum;
    }

    public void setHum(Float hum) {
        this.hum = hum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

