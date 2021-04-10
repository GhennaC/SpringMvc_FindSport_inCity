package org.challenge.dao;

import org.challenge.entities.City;
import org.challenge.entities.Sport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<City> getCities() {

        Query<City> query = sessionFactory.getCurrentSession().
                createQuery("from City order by name",City.class);

        return query.getResultList();
    }

    @Override
    public void saveCity(Sport sport) {

    }

    @Override
    public void deleteCitySport(int sportId) {

        Session session = sessionFactory.getCurrentSession();

        Sport sport = session.get(Sport.class,sportId);
        session.delete(sport);
    }

    @Override
    public Sport getCitySport(int id) {

        return sessionFactory.getCurrentSession().get(Sport.class,id);
    }

    public List<Sport> getSportsbyId(int id){

        City city = sessionFactory.getCurrentSession().get(City.class,id);
        return city.getSportList();

    }

    public void addCitySport(int id,Sport sport) {

        Session session = sessionFactory.getCurrentSession();
        City city = session.get(City.class,id);
        sport.setCity(city);

        // i have use session.clear cause when we try update a sport,
        // in session exists an object with same primary key,and it throws an exception
        session.clear();

        session.saveOrUpdate(sport);
    }

}
