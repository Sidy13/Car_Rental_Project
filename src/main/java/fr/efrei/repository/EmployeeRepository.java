package fr.efrei.repository;

import fr.efrei.domain.Employee;
import java.util.ArrayList;
import java.util.List;

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
    public Employee read(Integer id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        Integer id = employee.getEmployeeId();
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
    public boolean delete(Integer id) {
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
