package org.challenge.controllers;

import org.challenge.entities.Sport;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class ObjClass {

    @NotNull(message = "This is a required field")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date start_date;

    @NotNull(message = "This is a required field")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date stop_date;

    @Size(min = 1,message = "You need to select minimum one sport")
    private List<String> sportList;

    public ObjClass(){
    }

    public ObjClass(Date start_date, Date start_date1, List<String> sportList) {
        this.start_date = start_date;
        this.start_date = start_date1;
        this.sportList = sportList;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getStop_date() {
        return stop_date;
    }

    public void setStop_date(Date stop_date) {
        this.stop_date = stop_date;
    }

    public List<String> getSportList() {
        return sportList;
    }

    public void setSportList(List<String> sportList) {
        this.sportList = sportList;
    }

    @Override
    public String toString() {
        return "ObjClass{" +
                "start_date=" + start_date +
                ", stop_date=" + stop_date +
                ", sportList=" + sportList +
                '}';
    }
}


