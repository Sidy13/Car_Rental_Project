package fr.efrei.repository;

import fr.efrei.domain.Rental;
import java.util.ArrayList;
import java.util.List;


public class RentalRepository implements IRentalRepository {
    private static IRentalRepository repository = null;
    private List<Rental> rentalList;

    private RentalRepository() {
        rentalList = new ArrayList<>();
    }

    public static IRentalRepository getRepository() {
        if (repository == null) {
            repository = new RentalRepository();
        }
        return repository;
    }

    @Override
    public Rental create(Rental rental) {
        boolean success = rentalList.add(rental);
        if (success) {
            return rental;
        }
        return null;
    }

    @Override
    public Rental read(String id) {
        int rentPeriod;
        for (Rental rental : rentalList) {
            rentPeriod = rental.getRentPeriod();
            // Assumes Rental has a unique ID attribute like rentalId
            if (String.valueOf(rentPeriod).equals(id)) {
                return rental;
            }
        }
        return null;
    }

    @Override
    public Rental update(Rental rental) {
        int rentPeriod = rental.getRentPeriod();
        String id = String.valueOf(rentPeriod);
        Rental existingRental = read(id);
        if (existingRental == null) {
            return null;
        }
        boolean success = delete(id);
        if (success) {
            rentalList.add(rental);
            return rental;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Rental rentalToDelete = read(id);
        if (rentalToDelete == null) {
            return false;
        }
        return rentalList.remove(rentalToDelete);
    }

    @Override
    public List<Rental> getAll() {
        return new ArrayList<>(rentalList);
    }
}
