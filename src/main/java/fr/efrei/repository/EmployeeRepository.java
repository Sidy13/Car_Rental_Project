package fr.efrei.repository;

import fr.efrei.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeRepository implements IEmployeeRepository {
    private static IEmployeeRepository repository = null;
    private List<Employee> employeeList;

    private EmployeeRepository() {
        employeeList = new ArrayList<>();
    }

    public static IEmployeeRepository getRepository() {
        if (repository == null) {
            repository = new EmployeeRepository();
        }
        return repository;
    }

    @Override
    public Employee create(Employee employee) {
        boolean success = employeeList.add(employee);
        if (success) {
            return employee;
        }
        return null;
    }

    @Override
    public Employee read(String id) {
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getEmployeeId(), id)) {
                return employee;
            }
        }
        // Doing the same thing with Lambda expressions
        /*Employee employee = employeeList.stream().filter(e -> e.getEmployeeId().equals(id)).findAny().orElse(null);
        return employee;*/
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        String id = employee.getEmployeeId();
        Employee existingEmployee = read(id);
        if (existingEmployee == null) {
            return null;
        }
        boolean success = delete(id);
        if (success) {
            employeeList.add(employee);
            return employee;
        }
        return null;
    }


    @Override
    public boolean delete(String id) {
        Employee employeeToDelete = read(id);
        if (employeeToDelete == null) {
            return false;
        }
        return employeeList.remove(employeeToDelete);
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employeeList);
    }
}
