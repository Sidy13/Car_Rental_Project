package fr.efrei.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Rental {
    private int rentPeriod;
    private ArrayList<Car> cars = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(int rentPeriod, ArrayList<Car> cars, LocalDate startDate, LocalDate endDate) {
        this.rentPeriod = rentPeriod;
        this.cars = cars;
        this.startDate = startDate;
        this.endDate = endDate;
    }


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
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
    public void seeCarById(int carId) {
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
    public void seeCarByBrandAndModel(String brand, String model) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getModel().equals(model) && car.getBrand().equals(brand)) {
                iterator.remove();
                System.out.println(car);
                break;
            }
            else {
                System.out.println("No car called " + model+ " by "+ brand+ " found in the store.");
            }
        }
    }

    public void rentACar(Car car, Customer customer, LocalDate startDate, LocalDate endDate) {
        if (car.isAvailable(startDate, endDate)) {
            if (customer.pay()){
                car.setRented(true);
                car.setCurrentCustomer(customer);
                car.setStartDate(startDate);
                car.setEndDate(endDate);
                addCar(car);
                System.out.println("Car with ID " + car.getCarId() + " has been rented to " + customer.getFirstName() +" "+ customer.getLastName() + " from " + startDate + " to " + endDate);
            }
        } else {
            System.out.println("Car with ID " + car.getCarId() + " is not available for the given period.");
        }
    }

}

