package fr.efrei.repository;

import fr.efrei.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerRepository implements ICustomerRepository {
    private static ICustomerRepository repository = null;
    private List<Customer> customerList;

    private CustomerRepository() {
        customerList = new ArrayList<>();
    }

    public static ICustomerRepository getRepository() {
        if (repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }

    @Override
    public Customer create(Customer customer) {
        boolean success = customerList.add(customer);
        if (success) {
            return customer;
        }
        return null;
    }

    @Override
    public Customer read(String id) {
        for (Customer customer : customerList) {
            if (Objects.equals(customer.getCustomerId(), id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        String id = customer.getCustomerId();
        Customer existingCustomer = read(id);
        if (existingCustomer == null) {
            return null;
        }
        boolean success = delete(id);
        if (success) {
            customerList.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Customer customerToDelete = read(id);
        if (customerToDelete == null) {
            return false;
        }
        return customerList.remove(customerToDelete);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customerList);
    }
}
