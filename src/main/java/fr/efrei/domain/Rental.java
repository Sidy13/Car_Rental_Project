package fr.efrei.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Rental {
    private int rentPeriod;
    private ArrayList<Car> cars = new ArrayList<>();

    public Rental() {
    }

    public Rental(int rentPeriod, ArrayList<Car> cars) {
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
    public void removeCar(int carId) {
        Iterator<Car> iterator = cars.iterator();
        boolean carFound = false;

        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getCarId() == carId) {
                iterator.remove();
                carFound = true;
                System.out.println("Car with ID " + carId + " has been removed.");
                break;
            }
        }

        if (!carFound) {
            System.out.println("No car with ID " + carId + " found in the store.");
        }
    }
    public void seeCar(int carId) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getCarId() == carId) {
                iterator.remove();
                System.out.println(car);
                break;
            }
            else {
                System.out.println("No car with ID " + carId + " found in the store.");
            }
        }
    }
}

