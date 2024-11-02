package fr.efrei.domain;

import java.util.ArrayList;

public class Rental {
    private int rentPeriod;
    private ArrayList<Car> cars = new ArrayList<>();
    public Rental( int rentPeriod,  ArrayList<Car> cars) {
        this.rentPeriod = rentPeriod;
        this.cars = cars;
    }



    public int getRentPeriod() {
        return rentPeriod;
    }

    public void setRentPeriod(int rentPeriod) {
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

