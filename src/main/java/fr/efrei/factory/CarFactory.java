package fr.efrei.factory;

import fr.efrei.domain.Address;
import fr.efrei.domain.Car;
import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

import java.util.ArrayList;

public class CarFactory {
    public static Car createCar(String carId, String model, String brand, String color, String licensePlate, double kilometers, int year, double dayPrice, String insurance, ArrayList<String> options) {
        if (Helper.isNullOrEmpty(model) || Helper.isNullOrEmpty(brand) || Helper.isNullOrEmpty(color) || Helper.isNullOrEmpty(licensePlate) || Helper.isNullOrEmpty(insurance)) {
            return null;
        }
        if (carId.isEmpty() ||  kilometers < 0 || dayPrice < 0  || year<1900) {
            return null;
        }
        return new Car.Builder().setCarId(carId).
                setModel(model).
                setBrand(brand).
                setColor(color).
                setLicensePlate(licensePlate)
                .setKilometers(kilometers)
                .setInsurance(insurance)
                .setYear(year)
                .setDayPrice(dayPrice)
                .setOptions(options)
                .build();
    }
}