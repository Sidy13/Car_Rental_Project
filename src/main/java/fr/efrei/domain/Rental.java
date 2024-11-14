package fr.efrei.domain;

import java.util.ArrayList;
import java.util.Date;

public class Rental {
    private Date rentPeriod;
    private ArrayList<Car> cars = new ArrayList<>();
    public Rental( Date rentPeriod,  ArrayList<Car> cars) {
        this.rentPeriod = rentPeriod;
        this.cars = cars;
    }



    public Date getRentPeriod() {
        return rentPeriod;
    }

    public void setRentPeriod(Date rentPeriod) {
        this.rentPeriod = rentPeriod;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentPeriod=" + rentPeriod +
                ", cars=" + cars +
                '}';
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
    public void addCar(Car car) {
        cars.add(car);
    }
}

