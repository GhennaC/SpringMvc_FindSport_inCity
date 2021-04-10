package org.challenge.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "sport")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;

    @Column(name = "name")
    @Size(max = 25,message = "Maximum allowed size = 25")
    @NotEmpty(message = "The field of name can not be empty")
    private String name;

    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "The field of date can not be empty")
    private Date start_date;

    @Column(name = "stop_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "The field of date can not be empty")
    private Date stop_date;

    @Column(name = "price")
    @NotNull(message = "can not be null")
    private int price;

    @ManyToOne(cascade= {CascadeType.DETACH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.REFRESH,},targetEntity = City.class
                )
    @JoinColumn(name = "city_id")
    private City city;

    public Sport() {

    }

    public Sport(String name, Date start_date, Date stop_date, int price) {
        this.name = name;
        this.start_date = start_date;
        this.stop_date = stop_date;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start_date='" + start_date + '\'' +
                ", stop_date='" + stop_date + '\'' +
                ", price=" + price +
                '}';
    }
}
