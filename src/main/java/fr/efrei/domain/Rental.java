package fr.efrei.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Rental {
    private long rentPeriod;
    private List<Car> cars = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
    String pickUpLocation;

    public Rental(long rentPeriod, List<Car> cars, LocalDate startDate, LocalDate endDate, String pickUpLocation) {
        this.rentPeriod = rentPeriod;
        this.cars = cars;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickUpLocation = pickUpLocation;
    }


    public Rental() {
    }

    public Rental(int rentPeriod, List<Car> cars) {
        this.rentPeriod = rentPeriod;
        this.cars = cars;
    }



    public long getRentPeriod() {
        return rentPeriod;
    }

    public void setRentPeriod(int rentPeriod) {
        this.rentPeriod = rentPeriod;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentPeriod=" + rentPeriod +
                "days, cars=" + cars +
                ", pick up location='" + pickUpLocation + '\'' +
                '}';
    }

    public List<Car> getCars() {
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

    public void setRentPeriod(long rentPeriod) {
        this.rentPeriod = rentPeriod;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void addCar(Car car) {
        cars.add(car);
    }
    public void removeCar(String carId) {
        Car removedCar = null;
        for (Car car : cars) {
            if (car != null && Objects.equals(car.getCarId(), carId)) {
                cars.remove(car);
                removedCar = car;
                System.out.println("Car with ID " + carId + " has been removed.");
                break;
            }
        }

        if (removedCar == null) {
            System.out.println("No car with ID " + carId + " found in the store.");
        }
    }



    public void seeCarById(String carId) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (Objects.equals(car.getCarId(), carId)) {
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

    public void rentACar(Car car, Customer customer, LocalDate startDate, LocalDate endDate, long rentPeriod, String pickUpLocation) {
        if (car.isAvailable(startDate, endDate)) {
            if (customer.pay()){
                car.setRented(true);
                car.setCurrentCustomer(customer);
                car.setStartDate(startDate);
                car.setEndDate(endDate);
                addCar(car);
                this.startDate = startDate;
                this.endDate = endDate;
                this.rentPeriod = rentPeriod;
                this.pickUpLocation = pickUpLocation;
                double totalPrice = rentPeriod * car.getDayPrice();
                System.out.println("The " + car.getBrand()+ " "+ car.getModel()+ " car with ID " + car.getCarId() + " has been rented to " + customer.getFirstName() +" "+ customer.getLastName() + " from " + startDate + " to " + endDate + ", which represents a rent period of " + rentPeriod + " days and a total of " +totalPrice+ " euros and must be picked in "+pickUpLocation+ "\n");
            }
        } else {
            System.out.println("Car with ID " + car.getCarId() + " is not available for the given period.");
        }
    }


}