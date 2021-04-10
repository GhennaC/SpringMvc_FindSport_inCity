package org.challenge.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id",unique = true,nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private List<Sport> sportList;

    public City() {

    }

    public City(int id) {
        this.id = id;
    }
    public City(int id, String name, List<Sport> sportList) {
        this.id = id;
        this.name = name;
        this.sportList = sportList;
    }

    public City(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sport> getSportList() {
        return sportList;
    }

    public void setSportList(List<Sport> sportList) {
        this.sportList = sportList;
    }

    public void addSport(Sport sport) {
        if(sportList == null)
            sportList = new ArrayList<>();

        sportList.add(sport);
        sport.setCity(this);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sportList=" + sportList +
                '}';
    }
}
