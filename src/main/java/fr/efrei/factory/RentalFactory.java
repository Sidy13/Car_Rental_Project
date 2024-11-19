package fr.efrei.factory;

import fr.efrei.domain.Car;
import fr.efrei.domain.Rental;
import fr.efrei.util.Helper;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentalFactory {
    public static Rental createRental(ArrayList<Car> cars, LocalDate startDate, LocalDate endDate) {
        if (cars == null || cars.isEmpty()) {
            return null;
        }
        if (Helper.isNullOrEmpty(startDate) || Helper.isNullOrEmpty(endDate)) {
            return null;
        }
        if (startDate.isAfter(endDate)) {
            return null;
        }
        int rentPeriod = (int) java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        return new Rental(rentPeriod, cars, startDate, endDate);
    }
}
