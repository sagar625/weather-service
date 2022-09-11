package com.sensor.weatherservice.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class SensorDTO {
    private Long id;
    private String sensorName;
    private Float temp;
    private Float ws;
    private Float hum;

    @JsonProperty(value = "created_at")
    private Date createdAt;

    public SensorDTO(Long id, String sensorName, Float temp, Float ws, Float hum, Date createdAt) {
        this.id = id;
        this.sensorName = sensorName;
        this.temp = temp;
        this.ws = ws;
        this.hum = hum;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getWs() {
        return ws;
    }

    public void setWs(Float ws) {
        this.ws = ws;
    }

    public Float getHum() {
        return hum;
    }

    public void setHum(Float hum) {
        this.hum = hum;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

