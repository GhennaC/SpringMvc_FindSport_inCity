package org.challenge.dao;

import org.challenge.entities.Sport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class SportDaoImpl implements SportDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Sport> getSports() {

        Query<Sport> query = sessionFactory.getCurrentSession().
                createQuery("from Sport order by name",Sport.class);

        return query.getResultList();

    }

    @Override
    public void saveSport(Sport sport){

        sessionFactory.getCurrentSession().saveOrUpdate(sport);
    }

    public void deleteSport(int id) {

        Sport sport = sessionFactory.getCurrentSession().
                get(Sport.class,id);
        sessionFactory.getCurrentSession().delete(sport);
    }

    public Sport getSport(int id) {

        return sessionFactory.getCurrentSession().get(Sport.class,id);
    }

    public List<Sport> getNeededSports(List<String> list, Date start_date, Date stop_date){

        Session session = sessionFactory.getCurrentSession();

        List<Sport> sportList = session
                .createQuery("FROM Sport AS s  WHERE s.name in (: list) and " +
                                "s.start_date <= :st_date and s.stop_date >= :stop_dt" +
                                " order by s.price"
                        )
                .setParameter("list",list)
                .setParameter("st_date",start_date)
                .setParameter("stop_dt",stop_date)
                .list();

        return sportList;
    }

}
