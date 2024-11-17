package fr.efrei.repository;

import fr.efrei.domain.Customer;
import java.util.List;

public interface ICustomerRepository extends IRepository<Customer, String> {
    boolean delete(String id);

    List<Customer> getAll();
}
