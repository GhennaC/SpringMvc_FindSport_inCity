package org.challenge.service;

import org.challenge.entities.Sport;

import java.util.Date;
import java.util.List;

public interface SportService {

    public List<Sport> getSports();

    public void saveSport(Sport sport);

    public void deleteSport(int id);

    public Sport getSport(int id);

    public List<Sport> getNeededSports(List<String> list, Date start_date, Date stop_date);
}
