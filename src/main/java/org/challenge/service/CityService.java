package org.challenge.service;

import org.challenge.entities.City;
import org.challenge.entities.Sport;

import java.util.List;

public interface CityService {

    public List<City> getCities();

    public void saveCity(Sport sport);

    public void deleteCitySport(int id);

    public Sport getCitySport(int id);

    public List<Sport> getSportsbyId(int id);

    public void addCitySport(int id,Sport sport) ;
}
