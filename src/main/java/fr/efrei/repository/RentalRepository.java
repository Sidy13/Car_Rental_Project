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
    public Rental read(Integer id) {
        for (Rental rental : rentalList) {
            // Assumes Rental has a unique ID attribute like rentalId
            if (rental.getRentPeriod() == id) {
                return rental;
            }
        }
        return null;
    }

    @Override
    public Rental update(Rental rental) {
        Integer id = rental.getRentPeriod();
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
    public boolean delete(Integer id) {
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
