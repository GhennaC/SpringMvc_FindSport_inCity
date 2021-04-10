package org.challenge.service;

import org.challenge.dao.CityDao;
import org.challenge.dao.SportDao;
import org.challenge.entities.City;
import org.challenge.entities.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class MyService implements SportService,CityService {

    @Autowired
    private SportDao sportDao;

    @Autowired
    private CityDao cityDao;

    @Transactional
    @Override
    public List<Sport> getSports() {

        return sportDao.getSports();
    }

    @Transactional
    @Override
    public void saveSport(Sport sport) {

        sportDao.saveSport(sport);
    }

    @Transactional
    @Override
    public void deleteSport(int id) {

        sportDao.deleteSport(id);
    }

    @Transactional
    @Override
    public Sport getSport(int id) {

        return sportDao.getSport(id);
    }

    @Transactional
    @Override
    public List<City> getCities() {

        return cityDao.getCities();
    }

    @Transactional
    @Override
    public void saveCity(Sport sport) {

    }

    @Transactional
    @Override
    public void deleteCitySport(int id) {

        cityDao.deleteCitySport(id);
    }

    @Transactional
    @Override
    public Sport getCitySport(int id) {

        return cityDao.getCitySport(id);
    }

    @Transactional
    @Override
    public List<Sport> getSportsbyId(int id) {

        return cityDao.getSportsbyId(id);
    }

    @Transactional
    @Override
    public void addCitySport(int id,Sport sport) {

        cityDao.addCitySport(id,sport);
    }

    @Transactional
    @Override
    public List<Sport> getNeededSports(List<String> list, Date start_date, Date stop_date){

         return sportDao.getNeededSports(list,start_date,stop_date);
    }

}
