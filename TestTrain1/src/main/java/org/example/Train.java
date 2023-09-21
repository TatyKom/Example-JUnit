package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Train {
    private String name;
    private String stationStart;
    private String stationFinish;
    private double distance;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    public Train (String name, String stationStart, String stationFinish, double distance,
                  String  startTime, String finishTime) throws Exception {
        if (name == null)  {
            throw new Exception("Некорректный ввод");
        }
        if (stationStart == null)  {
            throw new Exception("Некорректный ввод");
        }
        if (stationFinish == null)  {
            throw new Exception("Некорректный ввод");
        }
        if (distance < 0) {
            throw new Exception("Некорректный ввод");
        }
        this.name = name;
        this.stationStart = stationStart;
        this.stationFinish = stationFinish;
        this.distance = distance;
        this.startTime = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.finishTime = LocalDateTime.parse(finishTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws Exception {
        if (name == null)  {
            throw new Exception("Некорректный ввод");
        }
        this.name = name;
    }
    public String getStationStart() {
        return stationStart;
    }
    public void setStationStart(String stationStart) throws Exception {
        if (stationStart == null)  {
            throw new Exception("Некорректный ввод");
        }
        this.stationStart = stationStart;
    }
    public String getStationFinish() {
        return stationFinish;
    }
    public void setStationFinish(String stationFinish) throws Exception {
        if (stationFinish == null)  {
            throw new Exception("Некорректный ввод");
        }
        this.stationFinish = stationFinish;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) throws Exception {
        if (distance < 0) {
            throw new Exception("Некорректный ввод");
        }
        this.distance = distance;
    }
    public String getStartTime() {
        return startTime.format((DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
    public void setStartTime(String startTime) {
        this.startTime = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
    public String getFinishTime() {
        return finishTime.format((DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
    public void setFinishTime(String finishTime) {
        this.finishTime = LocalDateTime.parse(finishTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public Long timeDistance() {
        return Duration.between(startTime, finishTime).toHours();
    }
    public double speed() {
        return distance/timeDistance();
    }
    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Train train) {
            return train.getName().equals(getName())
                    && getStationStart().equals(train.getStationStart())
                    && getStationFinish().equals(train.getStationFinish())
                    && getDistance() == train.getDistance()
                    && getStartTime().equals(train.getStartTime())
                    && getFinishTime().equals(train.getFinishTime());
        }
        return false;
    }
    @Override
    public String toString() {
        return "Поезд:  " + name + " следует от станции " + stationStart + " до станции "
                + stationFinish + ". Отбывает: " + startTime.format((DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                + ", прибывает: " + finishTime.format((DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}
